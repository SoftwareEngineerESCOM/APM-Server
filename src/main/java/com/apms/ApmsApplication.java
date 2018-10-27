package com.apms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ApmsApplication {
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ApmsApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(ApmsApplication.class, args);
	}
}
