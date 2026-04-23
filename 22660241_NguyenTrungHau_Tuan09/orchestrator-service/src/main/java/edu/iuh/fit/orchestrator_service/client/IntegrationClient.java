package edu.iuh.fit.orchestrator_service.client;

import edu.iuh.fit.orchestrator_service.dto.request.*;
import edu.iuh.fit.orchestrator_service.dto.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.math.BigDecimal;

@Component
public class IntegrationClient {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${services.user}")
    private String userUrl;

    @Value("${services.tour}")
    private String tourUrl;

    @Value("${services.booking}")
    private String bookingUrl;

    @Value("${services.payment}")
    private String paymentUrl;

    public UserResponse getUser(Long userId) {
        return restTemplate.getForObject(userUrl + "/" + userId, UserResponse.class);
    }

    public TourResponse getTour(Long tourId) {
        return restTemplate.getForObject(tourUrl + "/" + tourId, TourResponse.class);
    }

    public BookingResponse createBooking(BookingRequest request) {
        return restTemplate.postForObject(bookingUrl, request, BookingResponse.class);
    }

    public PaymentResult processPayment(Long bookingId, BigDecimal amount) {
        PaymentRequest paymentRequest = new PaymentRequest(bookingId, amount);
        return restTemplate.postForObject(paymentUrl, paymentRequest, PaymentResult.class);
    }

    public void cancelBooking(Long bookingId) {
        // Gửi request PUT (hoặc DELETE) để cập nhật trạng thái đơn thành CANCELLED
        restTemplate.put(bookingUrl + "/" + bookingId + "/cancel", null);
    }
}