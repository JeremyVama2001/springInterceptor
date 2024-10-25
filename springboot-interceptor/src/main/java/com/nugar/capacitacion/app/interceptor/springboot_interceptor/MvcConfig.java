package com.nugar.capacitacion.app.interceptor.springboot_interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer{

    @Autowired
    @Qualifier("timeInterceptor")
    private HandlerInterceptor timeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //Aqui van los patrones que queremos que se incluyan los interceptores
        registry.addInterceptor(timeInterceptor).addPathPatterns("/app/foo", "/app/bar");

        //Aqui se hace lo contrario, los que esten en esta lista se estaran exceptuando
        // registry.addInterceptor(timeInterceptor).excludePathPatterns("/app/foo", "/app/bar");
    }
    

}
