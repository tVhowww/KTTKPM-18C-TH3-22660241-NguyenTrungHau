package edu.iuh.fit.orchestrator_service.dto.request;

import lombok.Data;

@Data
public class BookingRequest {
    private Long userId;
    private Long tourId;
}