package dev.a2.onlinestore;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import dev.a2.onlinestore.model.Product;
import dev.a2.onlinestore.service.ProductService;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) throws Throwable {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    CommandLineRunner runner(ProductService productService) {
        return args -> {
            
            productService.save(new Product(1L, "Apple watch", new BigDecimal(200), "/img/applewatch.jpg"));
            productService.save(new Product(2L, "Headphones", new BigDecimal(200), "/img/headphones.png"));
            productService.save(new Product(3L, "iMac", new BigDecimal(200), "/img/imac.png"));
            productService.save(new Product(4L, "iPhone", new BigDecimal(200), "/img/iphone.jpeg"));
            productService.save(new Product(5L, "Keyboard", new BigDecimal(1200), "/img/keyboard.png"));
            productService.save(new Product(6L, "macbook", new BigDecimal(1200), "/img/macbook.png"));
            productService.save(new Product(7L, "quadrocopter", new BigDecimal(1200), "/img/quadrocopter.png"));
           
        };
    }

}