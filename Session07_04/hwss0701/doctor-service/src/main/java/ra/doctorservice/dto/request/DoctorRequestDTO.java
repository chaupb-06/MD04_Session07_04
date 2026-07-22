package ra.doctorservice.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DoctorRequestDTO {
    @NotBlank(message = "Không được để trống tên bác sĩ")
    private String name;
    @NotBlank(message = "Không được để trống chuyên khoa")
    private String specialization;
    @NotNull(message = "Không được để trống số năm kinh nghiệm")
    @Min(value = 0, message = "Số năm kinh nghiệm không được âm")
    private Integer experienceYears;
    @NotBlank(message = "Không được để trống email")
    @Email(message = "Không đúng định dạng của email")
    private String email;
    @NotNull(message = "Không được để trống trạng thái làm việc")
    private Boolean status;
}
