package dev.a2.onlinestore.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import dev.a2.onlinestore.dto.OrderProductDto;
import dev.a2.onlinestore.model.Order;
import dev.a2.onlinestore.model.OrderProduct;
import dev.a2.onlinestore.model.Product;
import dev.a2.onlinestore.service.ProductService;

@Controller
@SessionAttributes("order")
public class ProductController {
	
    private ProductService productService;
	
	public ProductController(ProductService productService) {
        this.productService = productService;
    }
	
	@ModelAttribute("order")
    public Order initCart() {
        return new Order();
    }
	
  	@GetMapping("/")
  	public String showProducts(Model model) {
  		model.addAttribute("products", productService.getAllProducts());
  		model.addAttribute("order");
  		return "home";
    }
  	
   	@GetMapping("/product/{productId}")
   	public String showProduct(Model model, @PathVariable String productId) {
   		Product product = productService.findById(Long.parseLong(productId));
   		model.addAttribute("product", product);
   		OrderProductDto orderProductDto = new OrderProductDto();
   		orderProductDto.setProduct(product);
   		model.addAttribute("orderProductDto", orderProductDto);
   		return "product";
    }
   	
 	@PostMapping("/product/{productId}")
 	public String processOrder(HttpSession session,
 			@PathVariable String productId,
 			@ModelAttribute("orderProductDto") OrderProductDto orderProductDto) {
 		
 		Order order = (Order) session.getAttribute("order");
 		
 		// Updating order products
		List<OrderProduct>orderProducts = order.getOrderProducts();
		boolean isFound = false;
		
		for (OrderProduct op : orderProducts) {
			if(op.getProduct().equals(orderProductDto.getProduct())) {
				op.setQuantity(op.getQuantity() + 1);
				isFound = true;
			}
        }
		
		// Creating an order product if none is found
		if (!isFound) {
			OrderProduct orderProduct = new OrderProduct(order, 
				orderProductDto.getProduct(), 
				orderProductDto.getQuantity());
			orderProducts.add(orderProduct);
		}

 		
 		return "redirect:/product/" + productId;
 	}
     
	
}
