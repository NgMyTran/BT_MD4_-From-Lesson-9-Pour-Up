package ra.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Medical {
    private int id;
    @NotEmpty(message = "Họ tên không được để trống.")
    private String fullName;
    @NotEmpty(message = "Số CMND không được để trống.")
    private String idCard;
    @NotNull(message = "Ngày sinh không được để trống.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
    private String healthStatus;
    private String travelHistory;


}
