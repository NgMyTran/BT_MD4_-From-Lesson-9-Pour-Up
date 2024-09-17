package controller;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.ProductService;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/")//dinh nghia mapping dg dan
    public String home(Model model) {
        //lay du lieu
        List<Product> productList=productService.getAll();
        //gui du lieu từ controller len view
        model.addAttribute("list", productList);
        return "home";
    }

    @RequestMapping("/product")//dinh nghia mapping dg dan
    public String product() {
        return "product";
    }

    @RequestMapping("/profile")//dinh nghia mapping dg dan
    public String profile() {
        return "profile";
    }

    @RequestMapping("/about")//dinh nghia mapping dg dan
    public String about() {
        return "about";
    }

    @RequestMapping("/input")//dinh nghia mapping dg dan
    public String input() {
        return "form";
    }
    @RequestMapping(value = "/input", method = RequestMethod.POST)
    public String doInput(
            @RequestParam String name,
            @RequestParam int age,
            @RequestParam String phone,
            @RequestParam String email,
            @RequestParam String address,
            Model model
    ){
        model.addAttribute("name",name);
        model.addAttribute("age",age);
        model.addAttribute("phone",phone);
        model.addAttribute("address",address);
        model.addAttribute("email",email);
        return "info";
    }
    @RequestMapping("/input-bt1")//dinh nghia mapping dg dan
    public String inputBt1() {
        return "/inputBt1";
    }

    @RequestMapping(value = "/input-bt1", method = RequestMethod.POST)
    public String doInputBt1(
            @RequestParam int amount,
            @RequestParam int rate,
            Model model
    ){
        model.addAttribute("amount",amount);
        model.addAttribute("rate",rate);
        return "formBt1";
    }

    @RequestMapping("/library")//dinh nghia mapping dg dan
    public String inputBt2() {
        return "/libraryBt2";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchBt2(
            @RequestParam String word,
            Model model
    ){
        String translation;
        if ("hello word".equalsIgnoreCase(word)) {
            translation = "Xin chào thế giới";
        } else {
            translation = "MyExample not found";
        }
        model.addAttribute("translation",translation);
        return "libraryBt2";
    }
}
