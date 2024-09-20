package ra.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc //use cau hinh mvc
@ComponentScan(basePackages = {"ra.controller"}) //quet package de tu dong phat hien bean(@Component, @Controller, @Service, @Respository)
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

    //cau hinh view
    //ding nghia bean
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");// folder chwas cacs giao dien trong web app
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSize(5*1024* 1024);
        resolver.setMaxUploadSize(25*1024*1024);
        return resolver;
    }

    // cấu hình đường dẫn ngoài /views/
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("/uploads/");
    }
}