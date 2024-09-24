package ra.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //    @Column(name = "fullName", nullable = false)
    private String fullName, email, password;

    @ManyToMany(fetch = FetchType.EAGER)//lay du lieu tuc thi, neu du lieu lon thi lay cham
    //khi onetotmany or manytomany k khai bao fetch thi no o trang thai lazy (LAZY:luoi bieng, data o trang thai dang cho, khi nao truy cap role qua getter thi moi lay ve, ho tro trong du lieu lon)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"), //taoj 1 cot chua khoa ngoaij
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;
}