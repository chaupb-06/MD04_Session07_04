package ra.patientservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PatientResponseDTO {
    private Long id;
    private String fullName;
    private LocalDate birthOfDate;
    private String gender;
    private String phoneNumber;
    private String address;
    private String medicalHistory;
}
