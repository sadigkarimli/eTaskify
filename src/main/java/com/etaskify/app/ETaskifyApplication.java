package com.etaskify.app;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@OpenAPIDefinition
@SpringBootApplication
public class ETaskifyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ETaskifyApplication.class, args);
    }
}
