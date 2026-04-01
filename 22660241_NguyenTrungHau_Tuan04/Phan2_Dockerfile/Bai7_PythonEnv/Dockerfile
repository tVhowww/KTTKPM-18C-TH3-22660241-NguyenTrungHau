# 1. Dùng bản slim cho nhẹ máy
FROM python:3.9-slim

# 2. Thiết lập biến môi trường mặc định theo yêu cầu
ENV APP_ENV=development

WORKDIR /app

# 3. Copy code vào container
COPY app.py .

# 4. Lệnh chạy script (Bài này chạy xong in ra màn hình rồi tự tắt, không cần giữ cổng như web server)
CMD ["python", "app.py"]