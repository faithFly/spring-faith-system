package com.faith.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description:
 * @author:faith
 * @time:2023/5/249:55
 */
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //允许跨域路径
        registry.addMapping("/**")
                //设置跨域请求的域名
                .allowedOrigins("*")
                //是否允许cookie
                .allowCredentials(true)
                //设置允许的请求方式
                .allowedMethods("GET","POST","PUT","DELETE")
                //设置允许的header属性
                .maxAge(3600);

    }
}
