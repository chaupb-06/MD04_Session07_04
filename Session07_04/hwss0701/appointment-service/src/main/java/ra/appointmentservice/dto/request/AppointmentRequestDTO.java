package ra.appointmentservice.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AppointmentRequestDTO {
    @NotNull(message = "Không được để trống id bệnh nhân!")
    private Long patientId;
    @NotNull(message = "Không được để trống id bác sĩ!")
    private Long doctorId;
    @NotNull(message = "Không được để trống ngày hẹn khám!")
    @JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    @Future(message = "Thời gian không phải là một thời gian trong quá khứ!")
    private LocalDateTime appointmentDate;
    @NotBlank(message = "Không được để trống lý do khám bệnh!")
    private String reason;
}
