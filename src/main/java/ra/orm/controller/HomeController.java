package ra.orm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ra.orm.model.FormRequest;
import ra.orm.validate.FormRequestValidate;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class HomeController {
    @Autowired
    private FormRequestValidate formRequestValidate;

    @GetMapping
    public String home(Model model) {
        FormRequest init = new FormRequest();
        init.setName("Hoa");
        init.setCheckboxValue("Hello");
        init.setSelectedValues(new ArrayList<>());
        model.addAttribute("formrequest", init);
        return "form";
    }

    @PostMapping("/validate")
    public String validate(@Valid @ModelAttribute("formrequest") FormRequest init, BindingResult result, Model model) {
       formRequestValidate.validate(init, result);
        if (result.hasErrors()) {
            model.addAttribute("formrequest", init);
            return "form";
        }else {
            return "home";
        }
    }
}
