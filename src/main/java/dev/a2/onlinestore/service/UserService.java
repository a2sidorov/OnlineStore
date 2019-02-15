package dev.a2.onlinestore.service;


import org.springframework.security.core.userdetails.UserDetailsService;

import dev.a2.onlinestore.dto.UserRegistrationDto;
import dev.a2.onlinestore.model.User;

public interface UserService extends UserDetailsService {
	
	User findByEmail(String email);
	
    User save(UserRegistrationDto userDto);
    
}
