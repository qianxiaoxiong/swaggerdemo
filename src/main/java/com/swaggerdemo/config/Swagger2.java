package com.swaggerdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
@ImportResource(locations = "classpath:spring.xml")
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        List<ResponseMessage> responseMessageList = new ArrayList<ResponseMessage>();
        return new Docket(DocumentationType.SWAGGER_2)
                .globalResponseMessage(RequestMethod.GET, responseMessageList)
                .globalResponseMessage(RequestMethod.POST, responseMessageList)
                .globalResponseMessage(RequestMethod.PUT, responseMessageList)
                .globalResponseMessage(RequestMethod.DELETE, responseMessageList)
//                .enable(true)  //是否启用swagger
                .apiInfo(apiInfo())
                .select()
                //唯一要改的地方就是这里的路径  其他不管
                .apis(RequestHandlerSelectors.basePackage("com.swaggerdemo"))
                //包：就是自己接口的包路径
                .paths(PathSelectors.any())
                .build();
    }




    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("商品系统api")//名字
                .description("商品系统接口文档说明")//额外藐视
                .contact(new Contact("qlb", "", "1139452801@qq.com"))
                .version("1.0")// 版本
                .build();
    }

}