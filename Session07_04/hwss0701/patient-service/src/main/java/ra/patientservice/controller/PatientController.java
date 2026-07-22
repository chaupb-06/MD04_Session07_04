package ra.patientservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.patientservice.dto.request.PatientRequestDTO;
import ra.patientservice.dto.response.ApiResponse;
import ra.patientservice.service.PatientService;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/patients")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;
    @PostMapping
    public ResponseEntity<ApiResponse<?>> createPatient(@Valid @RequestBody PatientRequestDTO patientRequestDTO) {
        return new ResponseEntity<>(new ApiResponse<>(
                true,
                "Đăng ký hồ sơ bệnh nhân thành công!",
                patientService.createPatient(patientRequestDTO),
                LocalDateTime.now()
        ), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> getPatient(@PathVariable long id) {
        return new ResponseEntity<>(new ApiResponse<>(
                true,
                "Lấy thông tin bệnh nhân thành công!",
                patientService.getPatientById(id),
                LocalDateTime.now()
        ), HttpStatus.OK);
    }
}
