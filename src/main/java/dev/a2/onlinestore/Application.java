package dev.a2.onlinestore;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import dev.a2.onlinestore.model.Product;
import dev.a2.onlinestore.service.ProductService;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Throwable {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    CommandLineRunner runner(ProductService productService) {
        return args -> {
            productService.save(new Product(1L, "iMac", new BigDecimal(1200), "http://placehold.it/200x100"));
            productService.save(new Product(2L, "Apple watch", new BigDecimal(200), "http://placehold.it/200x100"));
           
        };
    }

}