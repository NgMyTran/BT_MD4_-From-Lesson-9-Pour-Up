package ra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller//đánh dấu mỗi khi tạo controller
@RequestMapping//định nghĩa URL mapping áp dụng cho lớp (loại 2 là áp dụng cho phg thức)

public class HomeController {
    @RequestMapping// khớp vs dg dẫn rỗng
    public String home() {
        return "home";
    }

    @RequestMapping(value="/product", method= RequestMethod.POST)// khi dungf phg thuwcs posst thif xaif form owr views
    public String product() {
        return "product";
    }
}
