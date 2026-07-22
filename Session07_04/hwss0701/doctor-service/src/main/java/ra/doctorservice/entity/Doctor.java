package ra.doctorservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "doctors")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private Long id;
    @Column(length = 200, nullable = false)
    private String name;
    @Column(length = 200, nullable = false)
    private String specialization;
    @Column(name = "experience_years", nullable = false)
    private Integer experienceYears;
    @Column(length = 200, nullable = false, unique = true)
    private String email;
    @Column(nullable = false, columnDefinition = "boolean default true")
    @Builder.Default
    private Boolean status = true;
}
