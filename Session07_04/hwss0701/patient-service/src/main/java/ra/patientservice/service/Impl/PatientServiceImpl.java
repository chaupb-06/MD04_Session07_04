package ra.patientservice.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ra.patientservice.dto.request.PatientRequestDTO;
import ra.patientservice.dto.response.PatientResponseDTO;
import ra.patientservice.entity.Patient;
import ra.patientservice.exception.ResourceNotFoundException;
import ra.patientservice.repository.PatientRepository;
import ra.patientservice.service.PatientService;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;

    @Override
    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) {
        Patient patient = Patient.builder()
                .fullName(patientRequestDTO.getFullName())
                .dateOfBirth(patientRequestDTO.getDateOfBirth())
                .gender(patientRequestDTO.getGender())
                .phoneNumber(patientRequestDTO.getPhoneNumber())
                .address(patientRequestDTO.getAddress())
                .medicalHistory(patientRequestDTO.getMedicalHistory())
                .build();
        patientRepository.save(patient);
        return PatientResponseDTO.builder()
                .id(patient.getId())
                .fullName(patient.getFullName())
                .birthOfDate(LocalDate.from(patient.getDateOfBirth()))
                .gender(patient.getGender())
                .phoneNumber(patient.getPhoneNumber())
                .address(patientRequestDTO.getAddress())
                .medicalHistory(patient.getMedicalHistory())
                .build();
    }

    @Override
    public PatientResponseDTO getPatientById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tồn tại bệnh nhân có id " + id));
        return PatientResponseDTO.builder()
                .id(patient.getId())
                .fullName(patient.getFullName())
                .birthOfDate(patient.getDateOfBirth())
                .gender(patient.getGender())
                .phoneNumber(patient.getPhoneNumber())
                .address(patient.getAddress())
                .medicalHistory(patient.getMedicalHistory())
                .build();
    }
}
