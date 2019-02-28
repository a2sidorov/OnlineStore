package dev.a2.onlinestore.repos;

import org.springframework.data.repository.CrudRepository;

import dev.a2.onlinestore.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
