package edu.iuh.fit.inventory_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    // Use string serializer consistently for integers
    private static final String STOCK_KEY_PREFIX = "stock:";

    // Lấy tồn kho
    public int getStock(Long productId) {
        String stockStr = redisTemplate.opsForValue().get(STOCK_KEY_PREFIX + productId);
        return stockStr != null ? Integer.parseInt(stockStr) : 0;
    }

    // Bơm hàng vào kho (dành cho lúc Demo)
    public void initStock(Long productId, int quantity) {
        redisTemplate.opsForValue().set(STOCK_KEY_PREFIX + productId, String.valueOf(quantity));
    }

    // Trừ kho khi Checkout (Atomic Operation)
    public boolean deductStock(Long productId, int quantity) {
        String key = STOCK_KEY_PREFIX + productId;

        Long newStock = redisTemplate.opsForValue().decrement(key, quantity);

        if (newStock != null && newStock >= 0) {
            return true; // Trừ thành công
        } else {
            // Nếu bị âm (mua lố), trả lại hàng bằng increment (Rollback)
            if (newStock != null) {
                redisTemplate.opsForValue().increment(key, quantity);
            }
            return false;
        }
    }
}