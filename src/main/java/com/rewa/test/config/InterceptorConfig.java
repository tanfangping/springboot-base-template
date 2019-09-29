package com.rewa.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.rewa.test.interceptor.ResponseResultInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{

	public static String ALLPATH = "/**";
	@Autowired
	private ResponseResultInterceptor responseResultInterceptor;
	
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 对所有的请求都要拦截，但是“/getInt”不在拦截的范围之内
        registry.addInterceptor(responseResultInterceptor).addPathPatterns(ALLPATH);
    }
}
