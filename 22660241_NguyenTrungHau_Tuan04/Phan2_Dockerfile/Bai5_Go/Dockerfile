# 1. Sử dụng image Golang bản alpine (bản rút gọn, dung lượng nhẹ)
FROM golang:1.20-alpine

# 2. Thiết lập thư mục làm việc trong container
WORKDIR /app

# 3. Copy file định nghĩa module vào trước
COPY go.mod ./

# 4. Copy toàn bộ mã nguồn (.go) vào container
COPY *.go ./

# 5. Biên dịch mã nguồn Go thành một file chạy duy nhất có tên là "main"
RUN go build -o main .

# 6. Mở cổng 8080
EXPOSE 8080

# 7. Lệnh khởi chạy file binary vừa được biên dịch
CMD ["./main"]