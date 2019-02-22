package dev.a2.onlinestore.repos;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import dev.a2.onlinestore.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	Optional<Product> findById(Long id);

}
