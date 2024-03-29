package com.gidp.sure3odds;

import com.gidp.sure3odds.config.RequestFilterConfig;
import com.gidp.sure3odds.filter.RequestFilter;
import com.gidp.sure3odds.service.users.AuthenticationService;
import com.gidp.sure3odds.service.users.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Sure3oddsApplication {
    @Value("${cors.url}")
    String urls;

    @Autowired
    EmailService emailService;

    public static void main(String[] args) {
        SpringApplication.run(Sure3oddsApplication.class, args);
    }
    @Bean
    public FilterRegistrationBean<RequestFilter> requestSignatureFilterFilterRegistrationBean(RequestFilterConfig requestSignatureFilterConfig, AuthenticationService authenticationService) {
        RequestFilter requestSignatureFilter = new RequestFilter(requestSignatureFilterConfig,authenticationService);
        FilterRegistrationBean<RequestFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(requestSignatureFilter);
        registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        registrationBean.setAsyncSupported(false);
        return registrationBean;
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public WebMvcConfigurer corsConfigurer()
    {
        String [] origins = urls.split(",");
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins(origins);
            }
        };
    }


}
