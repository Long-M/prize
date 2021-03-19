package com.ml.prize.api.config;

import com.ml.prize.api.interceptor.RedisSessionInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Mr.ml
 * @date 2021/3/18
 */
@Configuration
public class WebSecurityConfig extends WebMvcConfigurerAdapter {

    @Bean
    public RedisSessionInterceptor getSessionInterceptor() {
        return new RedisSessionInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 所有以api开头的访问都要进入RedisSessionInterceptor拦截器进行登录验证，并排除login接口（全路径）。必须写成链式，分别设置的话会创建多个拦截器
        // 必须写成getSessionInterceptor()，否则SessionInterceptor中的@Resource会无效
        registry.addInterceptor(getSessionInterceptor()).addPathPatterns("/api/action/**").addPathPatterns("/api/user/**");
        super.addInterceptors(registry);
    }

}
