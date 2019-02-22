package dev.a2.onlinestore.dto;

import dev.a2.onlinestore.model.Product;

public class OrderProductDto {

    private Product product;
    private Integer quantity = 1;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

	@Override
	public String toString() {
		return "OrderProductDto [product=" + product + ", quantity=" + quantity + "]";
	}
    
    
}
