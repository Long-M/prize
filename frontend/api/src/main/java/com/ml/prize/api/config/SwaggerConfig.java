package com.ml.prize.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * @author Mr.ml
 * @date 2021/3/12
 */
@Configuration
@EnableSwagger2WebMvc
public class SwaggerConfig {

    @Value("${spring.application.name}")
    private String appName;

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                // 当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.ml.prize.api.controller"))
                .paths(PathSelectors.any()).build();

    }

    /**
     * 构建api文档的详细信息函数
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 页面标题
                .title("抽奖系统前端" + appName)
                // 创建人
                .contact(new Contact("Mr.ml", null, "350723986@qq.com"))
                // 版本号
                .version("1.0")
                // 描述
                .description("提供给前端页面调用的相关接口")
                .build();
    }

}
