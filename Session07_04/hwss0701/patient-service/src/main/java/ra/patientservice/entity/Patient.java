package ra.patientservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "patients")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Long id;
    @Column(name = "full_name", length = 200, nullable = false)
    private String fullName;
    @Column(name = "date_of_birth", nullable = false)
    @Builder.Default
    private LocalDate dateOfBirth = LocalDate.now();
    @Column(length = 50)
    private String gender;
    @Column(name = "phone_number", length = 15, nullable = false, unique = true)
    private String phoneNumber;
    @Column(nullable = false, columnDefinition = "text")
    private String address;
    @Column(name = "medical_history", nullable = false, columnDefinition = "text")
    private String medicalHistory;
}
