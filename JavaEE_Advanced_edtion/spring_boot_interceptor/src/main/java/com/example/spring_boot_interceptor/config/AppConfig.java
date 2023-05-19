package com.example.spring_boot_interceptor.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 方锐
 * @since 2023/5/16 15:01
 */
@Configuration
public class AppConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginInterceptor())
//                .addPathPatterns("/**")// 拦截所有请求
//                .excludePathPatterns("/user/login")// 不拦截的URL地址
//                .excludePathPatterns("/user/reg")
//                .excludePathPatterns("/**/*.html");
                 //如果没有排除 .html 文件，无法跳转到 login.html 那么就会一直重定向
    }

//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        configurer.addPathPrefix("/zhangsan", c -> true);
//    }

}