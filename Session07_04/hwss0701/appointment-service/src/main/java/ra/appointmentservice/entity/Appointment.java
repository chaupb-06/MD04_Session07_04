package ra.appointmentservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private Long id;
    @Column(name = "patient_id", nullable = false)
    private Long patientId;
    @Column(name = "doctor_id", nullable = false)
    private Long doctorId;
    @Column(name = "appointment_date", nullable = false)
    @Builder.Default
    private LocalDateTime appointmentDate = LocalDateTime.now();
    @Column(nullable = false, columnDefinition = "text")
    private String reason;
    @Column(length = 100, nullable = false)
    @Builder.Default
    private String status = "PENDING";
}
