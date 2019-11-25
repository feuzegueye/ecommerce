package com.ecommerce.ecommerceapi;

import com.ecommerce.ecommerceapi.models.ProductCategory;
import com.ecommerce.ecommerceapi.reposirories.ProductCategoryRepository;
import com.ecommerce.ecommerceapi.reposirories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableAutoConfiguration
public class EcommerceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApiApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ProductCategoryRepository productcategoryrepository) {

		return args -> {
			productcategoryrepository.save(new ProductCategory("Informatique", "informatique"));
		};
	}
}
