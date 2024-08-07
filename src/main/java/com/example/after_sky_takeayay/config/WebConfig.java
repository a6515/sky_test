package com.example.after_sky_takeayay.config;

import com.example.after_sky_takeayay.interceptors.LoginInterceptors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptors loginInterceptors;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //登录和注册接口放行
        registry.addInterceptor(loginInterceptors).excludePathPatterns("/user/ulogin",
                "/user/register","/user/getCategory","/user/getDish");

    }
}