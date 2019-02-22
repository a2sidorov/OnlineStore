package dev.a2.onlinestore.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import dev.a2.onlinestore.dto.OrderProductDto;
import dev.a2.onlinestore.dto.UserRegistrationDto;
import dev.a2.onlinestore.model.Order;
import dev.a2.onlinestore.model.OrderProduct;
import dev.a2.onlinestore.model.Product;
import dev.a2.onlinestore.service.OrderProductService;
import dev.a2.onlinestore.service.OrderService;
import dev.a2.onlinestore.service.ProductService;

@Controller
public class OrderControllerOLD {
	
	@Autowired
    private ProductService productService;
	
	@Autowired
    private OrderService orderService;
	
	@Autowired
    private OrderProductService orderProductService;
	/*
	// POST add a product to cart 
	@PostMapping("/order/add")
	public String processOrder(HttpSession session,
			@ModelAttribute("orderProductDto") OrderProductDto orderProductDto) {
		
		
		//session.setAttribute("Cart", value);
		System.out.println(orderProductDto);
		return "redirect:/";
	}
	*/

	/*
	// GET add a product to cart
	@GetMapping("/cart/add/{productId}")
	public String processOrder(HttpSession session, @PathVariable String productId) {
		Product product = productService.findById(Long.parseLong(productId));
		String sessionId = session.getId();
		Order order = orderService.findBySessionId(session.getId());
		
		// Creating a new order if none is found
		if (order == null) {
			order = new Order();
			order.setSessionId(sessionId);
			orderService.create(order);
		}
		
		// Updating order products
		List<OrderProduct >orderProducts = order.getOrderProducts();
		boolean isFound = false;
		
		for (OrderProduct op : orderProducts) {
			if(op.getProduct().equals(product)) {
				op.addOne();
				isFound = true;
			}
        }
		
		// Creating an order product if none is found
		if (!isFound) {
			OrderProduct orderProduct = new OrderProduct(order, product, 1);
			orderProduct = orderProductService.create(orderProduct);
			orderProducts.add(orderProduct);
		}
		
		orderService.update(order);
		return "redirect:/";
	}
	*/
   	
   	
   	// GET home page
   	@GetMapping("/cart")
   	public String showCart() {
   		return "cart";
     }

}
