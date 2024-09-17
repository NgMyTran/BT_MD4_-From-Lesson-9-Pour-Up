package bt.controller;

import bt.model.Employee;
import bt.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/employee")
    public String showEmployeeList(Model model) {
        List<Employee> employeeList= employeeService.getAll();
        model.addAttribute("list", employeeList);
        return "emplyeebt3/list-employee";
    }

@RequestMapping("/employee/add")
    public String showAddForm() {
        return "emplyeebt3/add-employee";
}

@RequestMapping(value = "/employee/add", method = RequestMethod.POST)
    public String doAddForm(Employee employee, Model model) {
        employee.setId(0);
        employeeService.save(employee);
        return "redirect:/employee";
}

    @RequestMapping("/employee/delete")
    public String showDeleteForm(@RequestParam int id, Model model) {
        model.addAttribute("employee", employeeService.findById(id));
        return "emplyeebt3/delete-employee";
    }

    @RequestMapping(value = "/employee/delete", method = RequestMethod.POST)
    public String doDeleteForm(@RequestParam int id) {
        employeeService.delete(id);
        return "redirect:/employee";
    }

    @RequestMapping(value = "/employee/edit", method = RequestMethod.POST)
    public String doEditForm(@ModelAttribute Employee employee) {
        employeeService.save(employee);
        return "redirect:/employee";
    }
}
