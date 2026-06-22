package com.java.vintageBooks.config;

import com.java.vintageBooks.interceptor.SessionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private SessionInterceptor sessionInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionInterceptor)
                .addPathPatterns("/**") 
                .excludePathPatterns(
                    "/",                        
                    "/buyersignin", "/buyersignup", "/buyerlogin",  
                    "/sellersignin", "/sellersignup", "/sellerlogin",
                    "/adminsigninpage", "/adminlogin",               
                    "/css/**",                  
                    "/js/**",                   
                    "/images/**",               
                    "/favicon.ico"              
                );
    }
}