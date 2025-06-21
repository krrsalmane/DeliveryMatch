package com.deliverymatch;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
    info = @Info(
        title = "DeliveryMatch API",
        version = "1.0",
        description = "API for DeliveryMatch Platform"
    )
)
public class DeliveryMatchApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeliveryMatchApplication.class, args);
    }
} 