package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ra.model.entity.Customer;
import ra.service.customer.ICustomerService;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping
    public String list(Model model){
        model.addAttribute("customers", customerService.findAll());
        return "list-customer";
    }
    @GetMapping("/add")
    public String add(){
        return "add-customer";
    }
    @PostMapping("/add")
    public String doAdd(@ModelAttribute Customer customer){
        customerService.save(customer);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("customer", customerService.findById(id));
        return "edit-customer";
    }

    @PostMapping("/update")
    public String doUpdate(@ModelAttribute Customer customer){
        customerService.save(customer);
        return "redirect:/";
    }
}
