package dev.a2.onlinestore.model;

import java.math.BigDecimal;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="product_id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name="name", updatable = true, nullable = false)
	@NotNull(message = "Product name is required")
	private String name;
	
	@Column(name="price", updatable = true, nullable = false)
	@NotNull(message = "Product price is required")
	private BigDecimal price;
	
	@Column(name="picture_url", updatable = true, nullable = false)
	@NotNull(message = "Product name is required")
	private String pictureUrl;
	
	public Product() {}
	
	public Product(Long id, @NotNull(message = "Product name is required.") String name, BigDecimal price, String pictureUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.pictureUrl = pictureUrl;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	
	

}
