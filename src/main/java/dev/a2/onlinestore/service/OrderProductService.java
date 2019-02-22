package dev.a2.onlinestore.service;

import org.springframework.validation.annotation.Validated;
import dev.a2.onlinestore.model.OrderProduct;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface OrderProductService {

    OrderProduct create(@NotNull(message = "The products for order cannot be null.") @Valid OrderProduct orderProduct);
}
