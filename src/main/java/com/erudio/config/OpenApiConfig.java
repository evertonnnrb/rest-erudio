package com.erudio.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("RESTful api wiht java 17 and SpringBoot 3.x.x")
                        .version("1.0")
                        .description("Case of study")
                        .termsOfService("")
                        .license(new License().name("Apache 2.0")));
    }
}
