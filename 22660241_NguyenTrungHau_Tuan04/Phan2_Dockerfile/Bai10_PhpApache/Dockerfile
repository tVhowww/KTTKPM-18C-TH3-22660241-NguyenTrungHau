# 1. Sử dụng image PHP 8.2 tích hợp sẵn Apache
FROM php:8.2-apache

# 2. Copy code từ máy thật vào thư mục public của Apache
# (Mặc dù lát nữa ta dùng Mount để ghi đè, nhưng vẫn nên có lệnh COPY để image này có thể chạy độc lập ở môi trường Production)
COPY index.php /var/www/html/

# 3. Mở cổng 80 (cổng mặc định của Apache)
EXPOSE 80