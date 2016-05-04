package com.lodewyk.jozijug.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import static springfox.documentation.builders.PathSelectors.regex;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@Configuration
@ComponentScan(basePackages = {"com.lodewyk.jozijug.controller", "com.lodewyk.jozijug.service"})
public class JoziJugApplication {

	public static void main(String[] args) {
		SpringApplication.run(JoziJugApplication.class);
	}
	
	@Bean
    public Docket joziJugApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Jozi-JUG")
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/.*"))
                .build();
    }
	
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Jozi-JUG REST micro-service")
                .description("This service exposes enpoints for the Jozi-JUG application")
                .contact("Lodewyk van der Merwe")
                .build();
    }
}
