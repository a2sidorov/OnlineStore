package dev.a2.onlinestore.dto;

import javax.validation.constraints.Size;

import dev.a2.onlinestore.validation.FieldMatch;
import dev.a2.onlinestore.validation.ValidEmail;
import dev.a2.onlinestore.validation.ValidPassword;


@FieldMatch(field = "password", fieldMatch = "confirmPassword")
public class UserSignupDto {
	
	@ValidEmail
    private String email;
	
    @Size(min=6, message = "Password must be at least 6 characters long")
    @Size(max=30, message = "Password must be less than 30 characters long")
	@ValidPassword(pattern = ".*[A-Z]+.*", message = "Password must contain at least one uppercase letter")
    @ValidPassword(pattern = ".*[a-z]+.*", message = "Password must contain at least one lowercase letter")
    @ValidPassword(pattern = ".*[0-9]+.*", message = "Password must contain at least one number")
    @ValidPassword(pattern = "^\\S+$", message = "Password must not contain spaces")
    private String password;
	
	
    private String confirmPassword;
    
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
    
    

}
