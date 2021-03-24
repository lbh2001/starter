package com.lbh.starter.config;

import com.lbh.starter.utils.Interceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author lbh
 * @Date 2021/3/24
 * @Description: 拦截器配置
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry){
        interceptorRegistry.addInterceptor(new Interceptor()).addPathPatterns("/**")
                .excludePathPatterns("/register");
    }
}
