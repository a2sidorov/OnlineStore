package dev.a2.onlinestore.repos;

import org.springframework.data.repository.CrudRepository;

import dev.a2.onlinestore.model.OrderProduct;
import dev.a2.onlinestore.model.OrderProductPK;

public interface OrderProductRepository extends CrudRepository<OrderProduct, OrderProductPK> {
}
