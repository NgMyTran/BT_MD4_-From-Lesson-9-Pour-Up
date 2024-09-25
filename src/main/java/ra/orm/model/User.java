package ra.orm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private int id;
    private String fullName;
    private String email;
    private String password;
    private String address;
    private String phone;
    private boolean status=true;
}
