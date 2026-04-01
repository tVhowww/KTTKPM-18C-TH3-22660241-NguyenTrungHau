# ==========================================
# STAGE 1: BUILD (Sử dụng node:18 bản đầy đủ)
# ==========================================
FROM node:18 AS builder

WORKDIR /build_app

# Copy package.json và cài đặt thư viện
COPY package*.json ./
RUN npm install

# Copy toàn bộ code và chạy lệnh build (tạo ra thư mục dist)
COPY . .
RUN npm run build


# ==========================================
# STAGE 2: RUN (Sử dụng node:18-alpine siêu nhẹ)
# ==========================================
FROM node:18-alpine

WORKDIR /app

# CHỈ COPY những thứ thực sự cần thiết từ Stage 1 sang Stage 2
# 1. Copy thư mục dist (code đã build)
COPY --from=builder /build_app/dist ./dist
# 2. Copy node_modules (các thư viện đã cài)
COPY --from=builder /build_app/node_modules ./node_modules
# 3. Copy package.json để có thể chạy lệnh npm start
COPY package*.json ./

EXPOSE 3000

CMD ["npm", "start"]