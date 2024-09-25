package ra.orm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ra.orm.model.FormRequest;
import ra.orm.model.Product;
import ra.orm.model.Song;
import ra.orm.model.User;
import ra.orm.validate.FormRequestValidate;
import ra.orm.validate.ProductValidate;
import ra.orm.validate.SongValidate;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class HomeController {
    @Autowired
    private FormRequestValidate formRequestValidate;
    @Autowired
    private SongValidate songValidate;
    @Autowired
    private ProductValidate productValidate;

    @GetMapping("/bt1")
    public String toRegisterForm(Model model) {
        model.addAttribute("userRegister", new User());
        return "register";
    }

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

    @GetMapping("/song")
    public String song(Model model) {
        model.addAttribute("song", new Song());
        return "song";
    }
    @PostMapping("/add-song")
    public String addSong(@Valid @ModelAttribute("song") Song song, BindingResult result, Model model) {
        songValidate.validate(song, result);
        if (result.hasErrors()) {
            model.addAttribute("song", song);
            return "song";
        }else {
            return "home";
        }
    }

    @GetMapping("/product")
    public String productForm(Model model) {
        model.addAttribute("product", new Product());
        return "product";
    }
    @PostMapping("/product-added")
    public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model) {
        productValidate.validate(product, result);
        if (result.hasErrors()) {
            model.addAttribute("product", product);
            return "product";
        }else {
            return "home";
        }
    }
}
