package rikkei.acedemy.model.bt2;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Candidate {
    private int id;
    private String firstName;
    private String lastName;
    private Date dob;
    private String phone;
    private String email;
}