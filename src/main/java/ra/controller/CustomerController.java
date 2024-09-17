package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ra.model.Customer;
import ra.service.customer.ICustomerService;

@Controller//cho du an hieu day la 1 controller

@RequestMapping("/customers")//quy dinh dg dan la gi, xem do la controller nao

public class CustomerController {
    @Autowired//k can khoi tao van chay binh thg
    private ICustomerService customerService;

    @RequestMapping("/list")
    public String showList(Model model) {
//instead of request.Attribute gui du lieu qua
        model.addAttribute("customers", customerService.getAll());
        return "list-customer";
    }

    @RequestMapping("/add")
    public String showFormAdd() {
        return "add-customer";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String doAdd(@ModelAttribute Customer customer) {
        customer.setId(0);
        customerService.save(customer);
        return "redirect:/customers/list";
    }
}
