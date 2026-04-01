# File: Phan2_Dockerfile/Bai4_NginxStatic/Dockerfile

# 1. Sử dụng image nginx mới nhất làm base
FROM nginx:latest

# 2. Copy file index.html từ máy host vào đúng thư mục mặc định của Nginx trong container
COPY index.html /usr/share/nginx/html/index.html

# 3. Nginx mặc định chạy ở cổng 80, ta expose cổng này ra
EXPOSE 80

# (Không cần lệnh CMD vì base image nginx đã tự động cấu hình lệnh khởi chạy web server rồi)