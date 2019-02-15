package dev.a2.onlinestore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.a2.onlinestore.service.ProductService;

@Controller
@RequestMapping("/")
public class ProductController {
	
    private ProductService productService;
	
	public ProductController(ProductService productService) {
        this.productService = productService;
    }
	
	// GET home page
  	@GetMapping
  	public String showProducts(Model model) {
  		model.addAttribute("products", productService.getAllProducts());
  		return "home";
    }
	
}
