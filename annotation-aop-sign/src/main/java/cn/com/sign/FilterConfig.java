package cn.com.sign;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: dongff
 * @description:
 * @date: Created in 2022-07-18 15:32
 * @modified By:
 */

@Configuration
public class FilterConfig {

    @Bean
    public RequestCachingFilter requestCachingFilter() {
        return new RequestCachingFilter();
    }

    @Bean
    public FilterRegistrationBean requestCachingFilterRegistration(
            RequestCachingFilter requestCachingFilter) {
        FilterRegistrationBean bean = new FilterRegistrationBean(requestCachingFilter);
        bean.setOrder(1);
        return bean;
    }
}
