# 1. Sử dụng python:3.9 làm base image
FROM python:3.9

# 2. Thiết lập thư mục làm việc
WORKDIR /app

# 3. Copy file requirements và cài đặt thư viện (Tối ưu cache của Docker)
COPY requirements.txt .
RUN pip install --no-cache-dir -r requirements.txt

# 4. Copy toàn bộ code vào container
COPY app.py .

# 5. Mở cổng 5000
EXPOSE 5000

# 6. Lệnh chạy ứng dụng Flask
CMD ["python", "app.py"]