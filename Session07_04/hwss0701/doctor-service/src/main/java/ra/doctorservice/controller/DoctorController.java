package ra.doctorservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.doctorservice.dto.request.DoctorRequestDTO;
import ra.doctorservice.dto.response.ApiResponse;
import ra.doctorservice.service.DoctorService;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/doctors")
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;
    @GetMapping
    public ResponseEntity<ApiResponse<?>> getAllDoctors() {
        return new ResponseEntity<>(new ApiResponse<>(
                true,
                "Lấy danh sách bác sĩ thành công!",
                doctorService.getAllDoctors(),
                LocalDateTime.now()
        ), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<ApiResponse<?>> createDoctor(@Valid @RequestBody DoctorRequestDTO doctorRequestDTO) {
        return new ResponseEntity<>(new ApiResponse<>(
                true,
                "Tạo hồ sơ bác sĩ thành công!",
                doctorService.createDoctor(doctorRequestDTO),
                LocalDateTime.now()
        ), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> getDoctorById(@PathVariable Long id) {
        return new ResponseEntity<>(new ApiResponse<>(
                true,
                "Lấy thông tin bác sĩ thành công!",
                doctorService.getDoctorById(id),
                LocalDateTime.now()
        ), HttpStatus.OK);
    }
}
