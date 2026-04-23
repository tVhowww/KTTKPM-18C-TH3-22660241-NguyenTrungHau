### API Test Script (Postman format)

Bạn có thể import các request sau vào Postman hoặc dùng cURL. Giả sử:
- `product-service` chạy ở cổng **8081** (tùy vào config của service này, mặc định dùng port bạn set)
- `inventory-service` chạy ở cổng **8084** (như config `server.port: 8084`)
- Redis đang chạy ở IP **192.168.1.69** port **6379**.

#### Kịch Bản (Scenario) Test:
1. Tạo tồn kho cho một số sản phẩm qua `inventory-service`
2. Lấy danh sách sản phẩm qua `product-service`
3. Kiểm tra lượng tồn kho qua `inventory-service`
4. Thực hiện checkout (trừ lượng tồn kho)

---

### Cụ Thể Các API Cần Test

#### 1. Khởi tạo / Bơm số lượng tồn kho cho sản phẩm (Inventory Service - Cổng 8084)
Dùng API init để tạo sẵn một lượng hàng (ví dụ: sản phẩm ID = 1 có 500 cái)

**Request 1 (Init Stock):**
- **Method:** `POST`
- **URL:** `http://localhost:8084/api/stock/init/1?quantity=500`

**Request 2 (Init Stock cho SP số 2):**
- **Method:** `POST`
- **URL:** `http://localhost:8084/api/stock/init/2?quantity=100`

---

#### 2. Xem Danh Sách Sản Phẩm (Product Service)
Giả định `product-service` đang chạy trên localhost (thường là cả API Gateway hoặc cổng trực tiếp 8081).
*Ghi chú: Product Service có `DataSeeder` có thể đã seed sản phẩm vào Redis sẵn.*

**Request 3 (Get All Products):**
- **Method:** `GET`
- **URL:** `http://localhost:8081/api/products` 
*(Thay 8081 bằng cổng thực tế của Product Service)*

**Request 4 (Get Product Info ID 1):**
- **Method:** `GET`
- **URL:** `http://localhost:8081/api/products/1`

---

#### 3. Kiểm Tra Tồn Kho (Inventory Service - Trước Checkout)
Kiểm tra xem dữ liệu trong cache hiện có đúng 500 không.

**Request 5 (Check Stock):**
- **Method:** `GET`
- **URL:** `http://localhost:8084/api/stock/1`

**Expected Response JSON:**
```json
{
    "productId": 1,
    "quantity": 500
}
```

---

#### 4. Khách hàng Checkout (Mua 1 hoặc nhiều)
Người dùng đặt hàng, gọi deductStock.

**Request 6 (Deduct Stock - Mua 1 cái):**
- **Method:** `POST`
- **URL:** `http://localhost:8084/api/stock/deduct/1`
- **Expected Response:** `Trừ kho thành công` (String)

**Request 7 (Deduct Stock - Mua nhiều = 10 cái):**
- **Method:** `POST`
- **URL:** `http://localhost:8084/api/stock/deduct/1?quantity=10`
- **Expected Response:** `Trừ kho thành công`

**Request 8 (Thử mua quá số lượng để test Rollback):**
- **Method:** `POST`
- **URL:** `http://localhost:8084/api/stock/deduct/1?quantity=9999`
- **Expected Response:** Status 400 Bad Request, Body: `Hết hàng (Out of stock)`

---

#### 5. Kiểm tra Tồn Kho Lại (Sau Checkout)
Stock của SP 1 ban đầu 500 - 1 - 10 = 489

**Request 9 (Check Stock Again):**
- **Method:** `GET`
- **URL:** `http://localhost:8084/api/stock/1`

**Expected Response JSON:**
```json
{
    "productId": 1,
    "quantity": 489
}
```

