package dev.a2.onlinestore.repos;

import org.springframework.data.repository.CrudRepository;
import dev.a2.onlinestore.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
