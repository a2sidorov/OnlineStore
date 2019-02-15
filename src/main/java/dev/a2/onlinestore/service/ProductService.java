package dev.a2.onlinestore.service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import dev.a2.onlinestore.model.Product;

public interface ProductService {
	
	@NotNull Iterable<Product> getAllProducts();
	
	Product getProduct(@Min(value = 1L, message = "Invalid product ID") long id);
	
	Product save(Product product);

}
