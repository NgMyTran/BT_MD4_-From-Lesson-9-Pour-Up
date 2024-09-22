package ra.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@AllArgsConstructor
@Getter
public class User1 {
    private int id;
    private String fullName;
    private String email;
    private String password;
    private String address;
    private String phone;
    private boolean status;
}