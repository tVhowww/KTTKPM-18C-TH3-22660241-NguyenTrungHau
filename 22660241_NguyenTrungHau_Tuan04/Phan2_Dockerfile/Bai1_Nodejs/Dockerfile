# 1. Sử dụng node:18 làm base image
FROM node:18

# 2. Tạo thư mục làm việc bên trong container
WORKDIR /usr/src/app

# 3. Copy file code từ máy thật vào container
COPY index.js .

# 4. Mở cổng 3000 để bên ngoài có thể truy cập
EXPOSE 3000

# 5. Lệnh khởi chạy ứng dụng khi container bắt đầu
CMD ["node", "index.js"]