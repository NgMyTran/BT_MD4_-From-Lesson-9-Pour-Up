package ra.model.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity
@Table(name="department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//tuwj tangw
    @Column(name = "department_id")
    private int id;
    @Column(name = "department_name", columnDefinition = "varchar(100)", unique=true)
    private String name;
    private boolean status;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)//2 chieefu
    //cascade: lan truyen
    private List<Employee> employees;
}
