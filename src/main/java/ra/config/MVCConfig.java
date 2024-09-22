package ra.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

@Configuration
@EnableWebMvc //use cau hinh mvc
@ComponentScan(basePackages = {"ra"})
//@ComponentScan(basePackages = {"ra.controller"})
//@ComponentScan(basePackages = {"ra.controller","bt"}) //quet package de tu dong phat hien bean(@Component, @Controller, @Service, @Respository)

// cau hinh mvc
public class MVCConfig implements ApplicationContextAware, WebMvcConfigurer {//cho phép một bean (đối tượng Spring) truy cập vào ApplicationContext (ngữ cảnh ứng dụng) của Spring
    //cho phép bean có thể truy cập các bean khác, tài nguyên và thông tin cấu hình trong ApplicationContextAware.
    //dungf khi cần truy cập hoặc tương tác với các bean khác trong Spring mà không cần phải inject chúng thông qua constructor or setter.
    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
    //WebMvcConfigurer:
    // tùy chỉnh các thành phần của Spring MVC(vd:
    // ghi đè các phương thức Cấu hình view resolvers
    // Cấu hình các đường dẫn và quản lý các request mappings.)để cấu hình ứng dụng web


    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/views/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding("UTF-8");
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setCharacterEncoding("UTF-8");
        viewResolver.setContentType("UTF-8");
        return viewResolver;
    }
}