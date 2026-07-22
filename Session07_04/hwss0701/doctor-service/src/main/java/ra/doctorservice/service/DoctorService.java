package ra.doctorservice.service;

import ra.doctorservice.dto.request.DoctorRequestDTO;
import ra.doctorservice.dto.response.DoctorResponseDTO;

import java.util.List;

public interface DoctorService {
    DoctorResponseDTO createDoctor(DoctorRequestDTO doctorRequestDTO);
    List<DoctorResponseDTO> getAllDoctors();
    DoctorResponseDTO getDoctorById(Long id);
}
