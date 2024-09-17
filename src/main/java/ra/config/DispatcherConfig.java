package ra.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class DispatcherConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {//cau hinh mvc o day, chua co thi tra ve mang =0
        return new Class[]{MVCConfig.class};//cú pháp khởi tạo mảng
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};//bieu thi servlet đến gốc của ứng dụng
    }

    //vietnamese
    @Override
    protected Filter[] getServletFilters() {
//        return super.getServletFilters();
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return new Filter[]{filter};// mang co 1 phan tu la filter
    }
}
