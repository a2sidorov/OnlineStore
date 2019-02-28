package dev.a2.onlinestore.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.a2.onlinestore.dto.UserSignupDto;
import dev.a2.onlinestore.model.User;
import dev.a2.onlinestore.service.UserService;

@Controller
@RequestMapping("/signup")
public class SignupController {
	
	@Autowired
    private UserService userService;
	
	@ModelAttribute("user")
    public UserSignupDto signupModel() {
        return new UserSignupDto();
    }
	
	@GetMapping
    public String showSignupForm(Model model) {
		model.addAttribute("signup", new User());
        return "signup";
    }
	
	@PostMapping
    public String signup(
    		@ModelAttribute("user") @Valid UserSignupDto userDto,
    		BindingResult result) {
		User existing = userService.findByEmail(userDto.getEmail());
		
        if (existing != null){
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()){
            return "signup";
        }

        userService.save(userDto);
        return "redirect:/signin";
    }

}
