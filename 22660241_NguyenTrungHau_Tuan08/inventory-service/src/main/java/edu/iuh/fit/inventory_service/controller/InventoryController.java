package edu.iuh.fit.inventory_service.controller;

import edu.iuh.fit.inventory_service.models.Inventory;
import edu.iuh.fit.inventory_service.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stock")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    // Xem tồn kho
    @GetMapping("/{productId}")
    public ResponseEntity<Inventory> getStock(@PathVariable Long productId) {
        int stock = inventoryService.getStock(productId);
        return ResponseEntity.ok(new Inventory(productId, stock));
    }

    // Order Service gọi API này khi Checkout
    @PostMapping("/deduct/{productId}")
    public ResponseEntity<String> deductStock(
            @PathVariable Long productId,
            @RequestParam(defaultValue = "1") int quantity) {

        boolean success = inventoryService.deductStock(productId, quantity);

        if (success) {
            return ResponseEntity.ok("Trừ kho thành công");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Hết hàng (Out of stock)");
        }
    }

    // API Hỗ trợ Demo: Tạo sẵn dữ liệu trong Redis
    @PostMapping("/init/{productId}")
    public ResponseEntity<String> initStock(
            @PathVariable Long productId,
            @RequestParam int quantity) {
        inventoryService.initStock(productId, quantity);
        return ResponseEntity.ok("Đã bơm " + quantity + " sản phẩm vào kho " + productId);
    }
}
