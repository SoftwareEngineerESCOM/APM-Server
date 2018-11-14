package com.apms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ApmsApplication {

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ApmsApplication.class);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("PUT", "DELETE", "GET", "POST", "PATCH");
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(ApmsApplication.class, args);
    }
}
