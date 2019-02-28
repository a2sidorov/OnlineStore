package dev.a2.onlinestore.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import dev.a2.onlinestore.model.Order;

@Controller
@SessionAttributes("order")
@Secured("ROLE_USER")
public class CheckoutController {
	
	@GetMapping("/checkout")
	public String checkoutOrder() {
   		return "checkout";
	}
}
