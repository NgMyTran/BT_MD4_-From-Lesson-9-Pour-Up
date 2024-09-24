package ra.model.entity;
import lombok.AllArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

//@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "role_name")
    private String name;

//    @ManyToMany
//    @JoinTable(
//            name = "user_role",
//            joinColumns = @JoinColumn(name = "role_id"), //taoj 1 cot chua khoa ngoaij
//            inverseJoinColumns = @JoinColumn(name = "user_id")
//    )//chi can lam ben chu the thoi, k can lam 2 chieu

//    @ManyToMany(mappedBy = "roles")//many to many dang phu thuoc vao thuoc tinh role, luc nay k con bang phu nua, chi con moi qhe 2 chieu.
//    //De tran bo nho --> chet server
//    private Set<User> users;
}
