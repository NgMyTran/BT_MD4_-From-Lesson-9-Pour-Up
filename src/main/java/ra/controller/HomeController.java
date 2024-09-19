package ra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping(value="/product", method= RequestMethod.POST)
    public String product() {
        return "product";
    }

    @RequestMapping("/sandwich")
    public String showForm(Model model) {
        model.addAttribute("condimentList", new String[]{"Ketchup", "Mustard", "Mayonnaise", "Relish"});
        return "sandwichForm";
    }

    @RequestMapping("/sandwich/save")
    public String save(@RequestParam("condiment") String[] condiments, Model model) {
        model.addAttribute("selectedCondiments", condiments);
        return "sandwichBill";
    }

    @RequestMapping("/calculate")
    public String showCalculate(Model model) {
        return "calculator";
    }

    @RequestMapping(value="/calculate", method=RequestMethod.POST)
    public String calculate(@RequestParam double num1,
                            @RequestParam double num2,
                            @RequestParam("operation") String operation,
                            Model model) {
        double result = 0;
        String operationSymbol = "";
        switch (operation) {
            case "+":
                result = num1 + num2;
                operationSymbol = " + ";
                break;
            case "-":
                result = num1 - num2;
                operationSymbol = " - ";
                break;
            case "*":
                result = num1 * num2;
                operationSymbol = " * ";
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                    operationSymbol = " / ";
                } else {
                    model.addAttribute("error", "Num2 khác 0");
                    return "calculateBt2";
                }
                break;
        }
        model.addAttribute("result", num1 + operationSymbol + num2 + " = " + result);
        return "calculateBt2";
    }
}
