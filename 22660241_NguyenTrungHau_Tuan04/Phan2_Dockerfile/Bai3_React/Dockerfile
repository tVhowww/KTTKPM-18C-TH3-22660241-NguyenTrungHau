# 1. Sử dụng node:18-alpine làm base image (bản alpine cực kỳ nhẹ)
FROM node:18-alpine

# 2. Thiết lập thư mục làm việc trong container
WORKDIR /app

# 3. Copy file package.json vào và cài đặt thư viện
# (Làm bước này trước để tận dụng cache của Docker, nếu không sửa file package.json thì bước npm install sẽ được skip ở các lần build sau)
COPY package.json ./
RUN npm install

# 4. Copy thư mục public (chứa index.html) vào container
COPY public ./public

# 5. Mở cổng 3000
EXPOSE 3000

# 6. Chạy lệnh "npm start" (tương đương lệnh serve -s public -p 3000 đã khai báo)
CMD ["npm", "start"]