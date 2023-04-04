package com.john.name.config;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.john.name.aspect.ControllerLogAop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author john
 * @version 1.0
 * @date 2020/5/23 14:03
 */
@Configuration
@EnableOpenApi
public class BeansConfig {
    @Bean
    public ControllerLogAop controllerLogAop() {
        return new ControllerLogAop();
    }

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(new ApiInfoBuilder()
                                 .title("babyName")
                                 .description("babyName")
                                 .contact(new Contact("knife", "https://knife.blog.csdn.net/", "xx@qq.com"))
                                 .version("1.0")
                                 .build())
                .groupName("all")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.john.name.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }
}
