package ra.mvc.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Account {
    private int id;
    private String username;
    private String password;
    private String fullName;
    private int balance;
}