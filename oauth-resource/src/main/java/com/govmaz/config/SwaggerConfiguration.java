package com.govmaz.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

//  @Bean
//  public Docket createRestApi() {
//    //添加header参数
//    ParameterBuilder ticketPar = new ParameterBuilder();
//    List<Parameter> pars = new ArrayList<>();
//    ticketPar.name("Authorization").description("bearer + access_token")
//            .modelRef(new ModelRef("string")).parameterType("header")
//            .required(false).build(); //header中的ticket参数非必填，传空也可以
//             pars.add(ticketPar.build());    //根据每个方法名也知道当前方法在设置什么参数
//    return new Docket(DocumentationType.SWAGGER_2)
//        .apiInfo(apiInfo())
//        .select()
//        .apis(RequestHandlerSelectors.basePackage("com.govmaz.controller"))
//        .paths(PathSelectors.any())
//        .build()
//        .globalOperationParameters(pars);
//  }
//
  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("政策查API接口文档")
        .description("")
        .version("1.0")
        .build();
  }

  @Bean(value = "defaultApi")
  public Docket defaultApi() {
    List<Parameter> pars = new ArrayList<Parameter>();

    ParameterBuilder tokenPar = new ParameterBuilder();
    tokenPar.name("Authorization").description("bearer + access_token")
        .modelRef(new ModelRef("String")).parameterType("header")
        .required(false).build(); //header中的Token参数必填，但是这里不能解决部分接口不需要token参数

    pars.add(tokenPar.build());
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.govmaz.controller.rest"))
        .paths(PathSelectors.any())
        .build().groupName("需要token验证")
        .globalOperationParameters(pars)
        .ignoredParameterTypes(HttpServletResponse.class, HttpServletRequest.class);
  }

  @Bean(value = "publicApi")
  public Docket publicApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.govmaz.controller.pub"))
        .paths(PathSelectors.any())
        .build().groupName("无需token验证")
        .ignoredParameterTypes(HttpServletResponse.class, HttpServletRequest.class);
  }
}
