package edu.iuh.fit.orchestrator_service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class PaymentRequest {
    private Long bookingId;
    private BigDecimal amount;
}