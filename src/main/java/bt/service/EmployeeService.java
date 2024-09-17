package bt.service;

import bt.model.Employee;
import model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class EmployeeService {
    private List<Employee> employeeList = new ArrayList<>(Arrays.asList(
            new Employee(1,"Mai","Cuu Long","0936482",true),
            new Employee(2,"Lan","Ca Mau","09364813",true),
            new Employee(3,"Truc","HCM","09364815",true)
    ));

    public List<Employee> getAll() {
        return employeeList;
    }

    public Employee findById(Integer id) {
        return employeeList.stream().filter(c -> c.getId() == id)
                .findFirst().orElse(null);
    }

    public void save(Employee employee) {
        if (findById(employee.getId()) == null) {
            employee.setId(getNewId());
            employeeList.add(employee);
        }else {
            employeeList.set(employeeList.indexOf(employee.getId()), employee);
        }
    }

    public void delete(Integer id) {
        Employee employee = findById(id);
        if (employee != null) {
            employeeList.remove(employee);
        }
    }

    private int getNewId(){
        return employeeList.stream().map(Employee::getId)
                .max(Comparator.naturalOrder())
                .orElse(0) + 1;
    }

}
