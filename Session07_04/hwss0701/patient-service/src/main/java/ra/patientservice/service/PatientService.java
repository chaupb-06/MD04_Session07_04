package ra.patientservice.service;

import ra.patientservice.dto.request.PatientRequestDTO;
import ra.patientservice.dto.response.PatientResponseDTO;

public interface PatientService {
    PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO);
    PatientResponseDTO getPatientById(Long id);
}
