import os

# Đọc biến môi trường APP_ENV. Nếu không tìm thấy, mặc định sẽ in ra 'Chưa xác định'
app_env = os.environ.get('APP_ENV', 'Chưa xác định')

print("="*50)
print(f"🚀 Xin chào! Ứng dụng Python khởi động thành công.")
print(f"🌍 Môi trường hiện tại đang chạy là: [{app_env.upper()}]")
print("="*50)