package edu.iuh.fit.orchestrator_service.service;

import edu.iuh.fit.orchestrator_service.client.IntegrationClient;
import edu.iuh.fit.orchestrator_service.dto.request.BookingRequest;
import edu.iuh.fit.orchestrator_service.dto.response.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;

@Service
@Slf4j
public class BookingOrchestratorService {

    @Autowired
    private IntegrationClient client;

    public String orchestrateBooking(BookingRequest request) {
        log.info("=== BẮT ĐẦU ĐIỀU PHỐI ĐẶT TOUR ===");
        log.info("User ID: {} | Tour ID: {}", request.getUserId(), request.getTourId());

        try {
            // 1. Kiểm tra User
            log.info("Bước 1: Xác thực User...");
            UserResponse user = client.getUser(request.getUserId());
            if (user == null) return "Thất bại: User không tồn tại!";

            // 2. Lấy thông tin Tour
            log.info("Bước 2: Lấy thông tin Tour...");
            TourResponse tour = client.getTour(request.getTourId());
            if (tour == null) return "Thất bại: Tour không tồn tại!";

            // 3. Tạo Booking
            log.info("Bước 3: Yêu cầu tạo Booking mới...");
            BookingResponse booking = client.createBooking(request);
            if (booking == null) return "Thất bại: Không thể tạo Booking!";

            // 4. Gọi Payment
            log.info("Bước 4: Gọi thanh toán cho Booking #{} với số tiền: {}", booking.getId(), tour.getPrice());
            PaymentResult payment = client.processPayment(booking.getId(), tour.getPrice());

            // 5. Trả kết quả và Xử lý Rollback (Compensating Transaction)
            if (payment != null && "SUCCESS".equals(payment.getStatus())) {
                log.info("=== ĐIỀU PHỐI THÀNH CÔNG ===");
                return "Thành công! Đã đặt tour #" + booking.getId() + " cho khách hàng " + user.getFullName();
            } else {
                log.warn("=== THANH TOÁN THẤT BẠI - BẮT ĐẦU ROLLBACK ===");

                // THÊM DÒNG NÀY ĐỂ KHỚP BIỂU ĐỒ: Gọi Booking Service để hủy đơn vừa tạo
                client.cancelBooking(booking.getId());

                return "Thất bại: Lỗi thanh toán cho Booking #" + booking.getId() + ". Đã tự động hủy đơn hàng.";
            }

        } catch (HttpClientErrorException e) {
            // Xử lý các lỗi 4xx (Ví dụ Tân hoặc Dương code API trả về 404 Not Found, 400 Bad Request)
            log.error("Lỗi dữ liệu đầu vào từ các Service: {}", e.getStatusCode());
            return "Thất bại: Dữ liệu không hợp lệ hoặc không tìm thấy (Mã lỗi: " + e.getStatusCode() + ")";

        } catch (ResourceAccessException e) {
            // Xử lý riêng lỗi sập mạng/tắt máy (Connection Refused)
            log.error("Lỗi kết nối mạng LAN: Không thể gọi đến Service khác.", e);
            return "Lỗi hệ thống: Một Service trong hệ thống đang bị mất kết nối.";

        } catch (Exception e) {
            // Bắt các lỗi 500 hoặc lỗi code Java khác
            log.error("Lỗi không xác định trong quá trình điều phối: ", e);
            return "Lỗi hệ thống trong quá trình điều phối.";
        }
    }
}