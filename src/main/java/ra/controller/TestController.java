package ra.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ra.dao.customertest.EmployeeTestDao;
import ra.model.entity.Category;
import ra.model.entity.Department;
import ra.model.entity.Employee;
import ra.model.entity.EmployeeTest;
import ra.service.category.ICategoryService;
import ra.service.customertest.IEmployeeTestSerice;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {
    @Autowired
    private IEmployeeTestSerice employeeTestService;
    @Autowired
    private ICategoryService categoryService;
//    private LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean;


//    @GetMapping
//    public String test() {
//        Department d1 = new Department(0,"Marketing", true, new ArrayList<>());
//        Employee e1=new Employee(0,"A", LocalDate.of(1999,10,10),true,"HN", "034878393",true,d1);
//        Employee e2=new Employee(0,"B", LocalDate.of(1999,10,11),false,"HCM", "034878394",true,d1);
//        List<Employee> list = new ArrayList<>();
//        list.add(e1);
//        list.add(e2);
//        SessionFactory sessionFactory=(SessionFactory) localContainerEntityManagerFactoryBean.getObject();
//        Session session= sessionFactory.openSession();
//        session.saveOrUpdate(d1);
//        return "home";
//    }
    @GetMapping
    public String index() {
       return "home";
    }

    @GetMapping("/employee")
    public String listEmployeeTest(Model model) {
        model.addAttribute("employeeTests", employeeTestService.findAll());
        return "list-employee-test";
    }
    @GetMapping("/employee-add")
    public String addEmployeeTestForm() {
        return "add-employee-test";
    }
    @Transactional
    @PostMapping("/employee-added")
    public String addEmployeeTest(@ModelAttribute EmployeeTest employeeTest) {
        employeeTestService.save(employeeTest);
        return "redirect:/employee";
    }

    @GetMapping("/category")
    public String listCategory(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "list-category";
    }
    @GetMapping("/category-add")
    public String addCategoryForm() {
        return "add-category";
    }
    @PostMapping("/category-added")
    public String addCategory(@ModelAttribute Category category) {
        categoryService.save(category);
        return "redirect:/category";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return"edit-category";
    }
    @PostMapping("/category-update")
    public String updateCategory(@ModelAttribute Category category) {
        categoryService.save(category);
        return "redirect:/category";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        categoryService.delete(id);
        return"redirect:/category";
    }
}
