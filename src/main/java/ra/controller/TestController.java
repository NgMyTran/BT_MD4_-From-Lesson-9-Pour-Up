package ra.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.dao.customertest.EmployeeTestDao;
import ra.model.entity.*;
import ra.service.category.ICategoryService;
import ra.service.customertest.IEmployeeTestSerice;
import ra.service.product.IProductService;

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
    @Autowired
    private IProductService productService;
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
    public String updateCategory( @ModelAttribute Category category) {
        categoryService.save(category);
        return "redirect:/category";
    }
    @PostMapping("/category/delete/{id}")
    public String deleteCategory(@PathVariable Integer id, @RequestParam boolean confirm) {
        Category category = categoryService.findById(id);
        // Cập nhật trạng thái của từng product thuộc category
        for (Product product : category.getProducts()) {
            product.setStatus(false);
            productService.save(product); // Lưu thay đổi cho sản phẩm
        }
        categoryService.delete(id);
        return "redirect:/category";
    }
//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable Integer id, Model model) {
//        model.addAttribute("category", categoryService.findById(id));
//        categoryService.delete(id);
//        return"redirect:/category";
//    }



    @GetMapping("/product")
    public String listProduct(Model model) {
        model.addAttribute("products", productService.findAll());
        return "list-product";
    }
    @GetMapping("/product-add")
    public String addProductForm(Model model) {
        //categories
        model.addAttribute("categoryList", categoryService.findActiveCategories());
        model.addAttribute("productList", productService.findAll());
        return "add-product";
    }
    @PostMapping("/product-added")
    public String addProduct(@ModelAttribute Product product,  @RequestParam Integer categoryId) {
        Category category = categoryService.findById(categoryId);
        product.setCategory(category);
        productService.save(product);
        return "redirect:/product";
    }
    @GetMapping("/product-edit/{id}")
    public String editProductForm(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("categoryList", categoryService.findAll());
        return "edit-product";
    };
    @PostMapping("/product-update")
    public String updateProduct(@ModelAttribute Product product,@RequestParam Integer categoryId) {
        Category category = categoryService.findById(categoryId);
        product.setCategory(category);
        productService.save(product);
        return "redirect:/product";
    }
    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        productService.delete(id);
        return "redirect:/product";
    }

}
