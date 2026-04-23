package edu.iuh.fit.orchestrator_service.controller;


import edu.iuh.fit.orchestrator_service.dto.request.BookingRequest;
import edu.iuh.fit.orchestrator_service.service.BookingOrchestratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BookingOrchestratorController {

    @Autowired
    private BookingOrchestratorService orchestratorService;

    @PostMapping("/book-tour")
    public ResponseEntity<String> bookTour(@RequestBody BookingRequest request) {
        // Giao toàn bộ request cho Service làm nhiệm vụ "nhạc trưởng" điều phối
        String resultMessage = orchestratorService.orchestrateBooking(request);

        // Dựa vào chuỗi kết quả trả về để quyết định HTTP Status Code cho Frontend
        if (resultMessage.startsWith("Thành công")) {
            return ResponseEntity.ok(resultMessage); // Trả về 200 OK
        } else {
            return ResponseEntity.badRequest().body(resultMessage); // Trả về 400 Bad Request kèm lý do lỗi
        }
    }
}