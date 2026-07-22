package ra.doctorservice.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ra.doctorservice.dto.request.DoctorRequestDTO;
import ra.doctorservice.dto.response.DoctorResponseDTO;
import ra.doctorservice.entity.Doctor;
import ra.doctorservice.exception.ResourceNotFoundException;
import ra.doctorservice.repository.DoctorRepository;
import ra.doctorservice.service.DoctorService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;

    @Override
    public DoctorResponseDTO createDoctor(DoctorRequestDTO doctorRequestDTO) {
        if (doctorRepository.existsByEmail(doctorRequestDTO.getEmail())) {
            throw new IllegalArgumentException("email đã tồn tại!");
        }
        Doctor doctor = Doctor.builder()
                .name(doctorRequestDTO.getName())
                .specialization(doctorRequestDTO.getSpecialization())
                .experienceYears(doctorRequestDTO.getExperienceYears())
                .email(doctorRequestDTO.getEmail())
                .status(doctorRequestDTO.getStatus())
                .build();
        doctorRepository.save(doctor);
        return DoctorResponseDTO.builder()
                .id(doctor.getId())
                .name(doctor.getName())
                .specialization(doctor.getSpecialization())
                .build();
    }

    @Override
    public List<DoctorResponseDTO> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors.stream()
                .map(doctor -> DoctorResponseDTO.builder()
                        .id(doctor.getId())
                        .name(doctor.getName())
                        .specialization(doctor.getSpecialization())
                        .build()
                ).toList();
    }

    @Override
    public DoctorResponseDTO getDoctorById(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tồn tại bác sĩ có id " + id));
        return DoctorResponseDTO.builder()
                .id(doctor.getId())
                .name(doctor.getName())
                .specialization(doctor.getSpecialization())
                .build();
    }
}
