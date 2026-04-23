package edu.iuh.fit.orchestrator_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TourResponse {
    private Long id;
    private BigDecimal price;
}