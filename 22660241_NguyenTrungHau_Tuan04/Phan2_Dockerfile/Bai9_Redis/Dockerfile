# 1. Sử dụng image redis mới nhất
FROM redis:latest

# 2. Copy file cấu hình từ máy host vào thư mục chứa config của Redis trong container
COPY redis.conf /usr/local/etc/redis/redis.conf

# 3. Mở cổng mặc định của Redis
EXPOSE 6379

# 4. Chạy Redis server VÀ chỉ định nó phải đọc file cấu hình của chúng ta
CMD [ "redis-server", "/usr/local/etc/redis/redis.conf" ]