package ra.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

//@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int id;
    @Column(name = "employee_name")
    private String name;

//    @Temporal(TemporalType.DATE)//ddaay laf localdate
    @Column(columnDefinition = "date")
    private LocalDate dob;
    private boolean sex;
    private String address;
    private String phone;
    private boolean status;

//    private int departmentId;
    @ManyToOne// k co fetch thi defult la eager
    @JoinColumn(name = "department_id")//didnhj nghiax khoas ngoaij
private Department department;// 1 đối tượng k thể laf 1 column
// quan hệ 1 chiều

}
