package ra.appointmentservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.appointmentservice.dto.request.AppointmentRequestDTO;
import ra.appointmentservice.dto.response.ApiResponse;
import ra.appointmentservice.service.AppointmentService;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/appointments")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;
    @PostMapping("/create")
    public ResponseEntity<ApiResponse<?>> createAppointment(@Valid @RequestBody AppointmentRequestDTO appointmentRequestDTO) {
        return new ResponseEntity<>(new ApiResponse<>(
                true,
                "Tạo giấy hẹn thành công!",
                appointmentService.createAppointment(appointmentRequestDTO),
                LocalDateTime.now()
        ), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<ApiResponse<?>> getAllAppointments() {
        return new ResponseEntity<>(new ApiResponse<>(
                true,
                "Lấy danh sách giấy hẹn thành công!",
                appointmentService.findAll(),
                LocalDateTime.now()
        ), HttpStatus.OK);
    }
}
