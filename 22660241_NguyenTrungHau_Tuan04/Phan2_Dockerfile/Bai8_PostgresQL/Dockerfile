# 1. Sử dụng image PostgreSQL bản 15
FROM postgres:15

# 2. Copy file init.sql vào "thư mục ma thuật" của Postgres
# Mọi file .sql ở đây sẽ được tự động thực thi khi container chạy lần đầu
COPY init.sql /docker-entrypoint-initdb.d/