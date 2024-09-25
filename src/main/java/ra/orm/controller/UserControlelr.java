package ra.orm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ra.orm.model.FormRequest;
import ra.orm.model.User;
import ra.orm.validate.LoginValidate;
import ra.orm.validate.RegisterValidate;

import javax.validation.Valid;

@Controller
public class UserControlelr {
    @Autowired
    private RegisterValidate registerValidate;
    @Autowired
    private LoginValidate loginValidate;

    @PostMapping("/registered")
    public String registered(@Valid @ModelAttribute("userRegister") User init, BindingResult result, Model model) {
        registerValidate.validate(init, result);
        if (result.hasErrors()) {
            model.addAttribute("userRegister", init);
            return "register";
        }else {
            return "login";
        }
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("userLogin", new User());
        return "login";
    }
    @PostMapping("/logged")
    public String logged(@Valid @ModelAttribute("userLogin") User init, BindingResult result, Model model) {
        loginValidate.validate(init, result);
        if (result.hasErrors()) {
            model.addAttribute("userLogin", init);
            return "login";
        }else {
            return "home";
        }
    }
}
