package ra.patientservice.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PatientRequestDTO {
    @NotBlank(message = "Không được để trống tên bệnh nhân!")
    private String fullName;
    @NotNull(message = "Không được để trống ngày tháng năm sinh của bệnh nhân!")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Past(message = "Không được là một ngày trong tương lai!")
    private LocalDate dateOfBirth;
    private String gender;
    @NotBlank(message = "Không được để trống số điện thoại của bệnh nhân!")
    @Pattern(regexp = "^0\\d{9}$", message = "Không đúng định dạng số điện thoại!")
    private String phoneNumber;
    @NotBlank(message = "Không được để trống địa chỉ của bệnh nhân!")
    private String address;
    @NotBlank(message = "Không được để trống tiền sử bệnh lý!")
    private String medicalHistory;
}
