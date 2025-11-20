package com.example.queledoy_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(
            new Info()
                .title("Queledoy Backend API")
                .version("1.0")
                .description("API REST para la aplicación Queledoy - Sistema de productos y usuarios")
                .contact(new Contact()
                    .name("Queledoy Team")
                    .email("support@queledoy.com"))
        );
    }
}