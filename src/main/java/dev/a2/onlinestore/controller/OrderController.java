package dev.a2.onlinestore.controller;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import dev.a2.onlinestore.dto.OrderProductDto;
import dev.a2.onlinestore.model.Order;
import dev.a2.onlinestore.model.Product;

@Controller
@SessionAttributes("order")
public class OrderController {
	
	@GetMapping("/order")
	public String showCart(Model model) {
		model.addAttribute("order");
		model.addAttribute("message", "test");
		return "order";
	}
	
	@GetMapping("/order/quantity")
   	public String updateQuantity(HttpSession session, 
   			@RequestParam String action,  
   			@RequestParam String id) {
		Order order = (Order) session.getAttribute("order");
		order.getOrderProducts().stream().forEach(op -> {
			if (op.getProduct().getId() == Long.parseLong(id)) {
				if (action.equals("add")) {
					op.setQuantity(op.getQuantity() + 1);
				}
				if (action.equals("subtract")) {
					int result = op.getQuantity() - 1 > 0 ? op.getQuantity() - 1 : op.getQuantity();
					op.setQuantity(result);
				}
			}
		});
   		return "redirect:/order";
    }
	
	/*
	@PostMapping("/order/quantity/add")
	@ResponseBody
    public ResponseEntity<Order> updateQuantity(HttpSession session, @RequestBody Product product) {
		Order order = (Order) session.getAttribute("order");
		order.getOrderProducts().stream().forEach(op -> {
			if (op.getProduct().equals(product)) {
				op.setQuantity(op.getQuantity() + 1);
			}
		});
		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}
	*/
	

}
