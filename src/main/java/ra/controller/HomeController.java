package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.model.Product;
import ra.service.ProductService;

import java.util.List;

@Controller
//@RequestMapping
public class HomeController {
//@Autowired
//private ProductService productService;
private final ProductService productService;

    @Autowired
    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping
    public String home(Model model) {
        int age=10;
        String name="Hoa";
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        model.addAttribute("age",age);
        model.addAttribute("name", name);

        model.addAttribute("numbers", numbers);
        return "home";
    }

    @GetMapping("/products")
    public String product(Model model) {
        model.addAttribute("productList",productService.getAll());
        return "list-product";
    }

    @GetMapping("/products-add")
    public String addProduct() {
        return "add-product";
    }
    @PostMapping("/products-added")
    public String addProduct(@ModelAttribute Product product) {
        System.out.println("Adding product: " + product);
        productService.save(product);
        return "redirect:/products";
    }

    @GetMapping("/products/{id}/edit")
    public String editProduct(@PathVariable int id, Model model) {
        model.addAttribute("pro",productService.findById(id));
        return "edit-product";
    }
@PostMapping("/products/{id}/update")
    public String updateProduct(@PathVariable int id,@ModelAttribute Product product) {
        product.setId(id);
        productService.save(product);
        return "redirect:/products";
}

@GetMapping("/products/{id}/delete")
    public String deleteProduct(@PathVariable int id) {
        productService.delete(id);
        return "redirect:/products";
}

@GetMapping("/products/{id}/detail")
    public String detailProduct(@PathVariable int id, Model model) {
        model.addAttribute("product",productService.findById(id));
        return "detail-product";
}
}
