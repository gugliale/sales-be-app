package com.griesi.sales;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(title = "Shopping basket APIs", version = "1.0", description = "Documentation of Shopping basket APIs")
)

@SpringBootApplication
public class SalesTaxesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesTaxesApplication.class, args);
	}

}
