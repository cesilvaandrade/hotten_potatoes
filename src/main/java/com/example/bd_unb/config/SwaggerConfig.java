package com.example.bd_unb.config;//package com.bd_unb.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//
//	private static final String BASE_PACKEG = "com.bd_unb";
//	private static final String TITLE = "Library Manager";
//	private static final String DESCRIPTION = "A simple API from library";
//	private static final String VERSION = "1.0.0";
//	private static final String NAME = "bd_unb Cezar";
//	private static final String GITHUB = "https://github.com/bd_unbcezar";
//	private static final String EMAIL = "bd_unbcezar312@gmail.com";
//
//	@Bean
//	public Docket api() {
//		return new Docket(DocumentationType.SWAGGER_2)
//				.select()
//				.apis(RequestHandlerSelectors.basePackage(BASE_PACKEG))
//				.paths(PathSelectors.any())
//				.build()
//				.apiInfo(buildApiInfo());
//	}
//
//	private static ApiInfo buildApiInfo() {
//		return new ApiInfoBuilder()
//				.title(SwaggerConfig.TITLE)
//				.description(DESCRIPTION)
//				.version(VERSION)
//				.contact(new Contact(NAME, GITHUB, EMAIL))
//				.build();
//	}
//}
