package ra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration//chú thích để hiểu đây là cấu hình của mvc - dùng để khởi tạo bean (BEAN ???)
@EnableWebMvc//để dùng được c.hình mvc
@ComponentScan(basePackages = "ra")//quét dự án để hiểu đc bean

public class MVCConfig {
// cấu hình views (để xem views nằm ở đâu)
    @Bean //tao 1 bean
    public ViewResolver viewResolver() { // phg thức trả về 1 resolver of 1 bean --> khi đã là 1 bean thì sẽ tự tạo đối tg mà ta k cần khởi tạo nữa (chỉ có 1 obj duy nhất)
        UrlBasedViewResolver viewResolver = new InternalResourceViewResolver();
        // read all jsp file in views
        viewResolver.setPrefix("/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
