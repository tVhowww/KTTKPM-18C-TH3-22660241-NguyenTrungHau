package edu.iuh.fit.orchestrator_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResult {
    // Trạng thái thanh toán, Người 5 sẽ trả về chuỗi "SUCCESS" hoặc "FAILED"
    private String status;
}