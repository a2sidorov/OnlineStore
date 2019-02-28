package dev.a2.onlinestore.dto;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

import dev.a2.onlinestore.dto.UserSignupDto;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@DisplayName("Testing UserSignupDto validation")
public class UserSignupDtoValidationTest {
	
	@Autowired
	private Validator validator;
    
    @DisplayName("when email empty then return false")
	@Test
	void validateEmailTest1() {
		//given
    	UserSignupDto userSignupDto = new UserSignupDto();
        userSignupDto.setEmail("");
        userSignupDto.setPassword("Password1");
        userSignupDto.setConfirmPassword("Password1");

        //run
        Set<ConstraintViolation<UserSignupDto>> violations = validator.validate(userSignupDto);
        String message = violations.iterator().next().getMessage();

        //assert
        assertEquals("Email is not valid", message);
	}
   
	
	@DisplayName("when email has no @ character then return false")
	@Test
	void validateEmailTest2() {
		//given
    	UserSignupDto userSignupDto = new UserSignupDto();
        userSignupDto.setEmail("Abc.example.com");
        userSignupDto.setPassword("Password1");
        userSignupDto.setConfirmPassword("Password1");

        //run
        Set<ConstraintViolation<UserSignupDto>> violations = validator.validate(userSignupDto);
        String message = violations.iterator().next().getMessage();

        //assert
        assertEquals("Email is not valid", message);
	}
	
	@DisplayName("when email has more than one @ character then return false")
	@Test
	void validateEmailTest3() {
		//given
    	UserSignupDto userSignupDto = new UserSignupDto();
        userSignupDto.setEmail("A@b@c@example.com");
        userSignupDto.setPassword("Password1");
        userSignupDto.setConfirmPassword("Password1");

        //run
        Set<ConstraintViolation<UserSignupDto>> violations = validator.validate(userSignupDto);
        String message = violations.iterator().next().getMessage();

        //assert
        assertEquals("Email is not valid", message);
	}
	
	@DisplayName("when email has special outside quotation marks then return false")
	@Test
	void validateEmailTest4() {
		//given
    	UserSignupDto userSignupDto = new UserSignupDto();
        userSignupDto.setEmail("a\\\"b(c)d,e:f;g<h>i[j\\\\k]l@example.com");
        userSignupDto.setPassword("Password1");
        userSignupDto.setConfirmPassword("Password1");

        //run
        Set<ConstraintViolation<UserSignupDto>> violations = validator.validate(userSignupDto);
        String message = violations.iterator().next().getMessage();

        //assert
        assertEquals("Email is not valid", message);
	}
	
	@DisplayName("when email has quoted strings without dot separation then return false")
	@Test
	void validateEmailTest5() {
		//given
    	UserSignupDto userSignupDto = new UserSignupDto();
        userSignupDto.setEmail("just\\\"not\\\"right@example.com");
        userSignupDto.setPassword("Password1");
        userSignupDto.setConfirmPassword("Password1");

        //run
        Set<ConstraintViolation<UserSignupDto>> violations = validator.validate(userSignupDto);
        String message = violations.iterator().next().getMessage();

        //assert
        assertEquals("Email is not valid", message);
	}
	
	@DisplayName("when email has escaped spaces, quotes, and backslashes outside quotation marks then return false")
	@Test
	void validateEmailTest6() {
		//given
    	UserSignupDto userSignupDto = new UserSignupDto();
        userSignupDto.setEmail("this\\\\ still\\\\\\\"not\\\\\\\\allowed@example.com");
        userSignupDto.setPassword("Password1");
        userSignupDto.setConfirmPassword("Password1");

        //run
        Set<ConstraintViolation<UserSignupDto>> violations = validator.validate(userSignupDto);
        String message = violations.iterator().next().getMessage();

        //assert
        assertEquals("Email is not valid", message);
	}
	
	@DisplayName("when email has double dot before @ then return false")
	@Test
	void validateEmailTest8() {
		//given
    	UserSignupDto userSignupDto = new UserSignupDto();
        userSignupDto.setEmail("ohn..doe@example.com");
        userSignupDto.setPassword("Password1");
        userSignupDto.setConfirmPassword("Password1");

        //run
        Set<ConstraintViolation<UserSignupDto>> violations = validator.validate(userSignupDto);
        String message = violations.iterator().next().getMessage();

        //assert
        assertEquals("Email is not valid", message);
	}
	
	@DisplayName("when email has double dot after @ then return false")
	@Test
	void validateEmailTest9() {
		//given
    	UserSignupDto userSignupDto = new UserSignupDto();
        userSignupDto.setEmail("john.doe@example..com");
        userSignupDto.setPassword("Password1");
        userSignupDto.setConfirmPassword("Password1");

        //run
        Set<ConstraintViolation<UserSignupDto>> violations = validator.validate(userSignupDto);
        String message = violations.iterator().next().getMessage();

        //assert
        assertEquals("Email is not valid", message);
	}
	
	@DisplayName("when email is valid then return true")
	@Test
	void validateEmailTest10() {
		//given
    	UserSignupDto userSignupDto = new UserSignupDto();
        userSignupDto.setEmail("foo@bar.com");
        userSignupDto.setPassword("Password1");
        userSignupDto.setConfirmPassword("Password1");

        //run
        Set<ConstraintViolation<UserSignupDto>> violations = validator.validate(userSignupDto);

        //assert
        assertTrue(violations.isEmpty());
	}
	
	@DisplayName("when password is empty then validation fails")
	@Test
	void validatePasswordTest1() {
		//given
    	UserSignupDto userSignupDto = new UserSignupDto();
        userSignupDto.setEmail("foo@bar.com");
        userSignupDto.setPassword("");
        userSignupDto.setConfirmPassword("");

        //run
        Set<ConstraintViolation<UserSignupDto>> violations = validator.validate(userSignupDto);

        //assert
        assertFalse(violations.isEmpty());
	}
	
	@DisplayName("when password length is less than 6 characters then validation fails")
	@Test
	void validatePasswordTest2() {
		//given
    	UserSignupDto userSignupDto = new UserSignupDto();
        userSignupDto.setEmail("foo@bar.com");
        userSignupDto.setPassword("Pass1");
        userSignupDto.setConfirmPassword("Pass1");

        //run
        Set<ConstraintViolation<UserSignupDto>> violations = validator.validate(userSignupDto);
        String message = violations.iterator().next().getMessage();

        //assert
        assertEquals("Password must be at least 6 characters long", message);
	}
	
	@DisplayName("when password length is greater than 30 characters then validation fails")
	@Test
	void validatePasswordTest3() {
		//given
    	UserSignupDto userSignupDto = new UserSignupDto();
        userSignupDto.setEmail("foo@bar.com");
        userSignupDto.setPassword("Passdown123456789012345678901234567890");
        userSignupDto.setConfirmPassword("Passdown123456789012345678901234567890");

        //run
        Set<ConstraintViolation<UserSignupDto>> violations = validator.validate(userSignupDto);
        String message = violations.iterator().next().getMessage();

        //assert
        assertEquals("Password must be less than 30 characters long", message);
	}
	
	@DisplayName("when password has no uppercase letter then validation fails")
	@Test
	void validatePasswordTest4() {
		//given
    	UserSignupDto userSignupDto = new UserSignupDto();
        userSignupDto.setEmail("foo@bar.com");
        userSignupDto.setPassword("password1");
        userSignupDto.setConfirmPassword("password1");

        //run
        Set<ConstraintViolation<UserSignupDto>> violations = validator.validate(userSignupDto);
        String message = violations.iterator().next().getMessage();

        //assert
        assertEquals("Password must contain at least one uppercase letter", message);
	}
	
	@DisplayName("when password has no lowercase letter then validation fails")
	@Test
	void validatePasswordTest5() {
		//given
    	UserSignupDto userSignupDto = new UserSignupDto();
        userSignupDto.setEmail("foo@bar.com");
        userSignupDto.setPassword("PASSWORD1");
        userSignupDto.setConfirmPassword("PASSWORD1");

        //run
        Set<ConstraintViolation<UserSignupDto>> violations = validator.validate(userSignupDto);
        String message = violations.iterator().next().getMessage();

        //assert
        assertEquals("Password must contain at least one lowercase letter", message);
	}
	
	@DisplayName("when password has no numbers then validation fails")
	@Test
	void validatePasswordTest6() {
		//given
    	UserSignupDto userSignupDto = new UserSignupDto();
        userSignupDto.setEmail("foo@bar.com");
        userSignupDto.setPassword("Password");
        userSignupDto.setConfirmPassword("Password");

        //run
        Set<ConstraintViolation<UserSignupDto>> violations = validator.validate(userSignupDto);
        String message = violations.iterator().next().getMessage();

        //assert
        assertEquals("Password must contain at least one number", message);
	}
	
	@DisplayName("when password has a space or spaces then validation fails")
	@Test
	void validatePasswordTest7() {
		//given
    	UserSignupDto userSignupDto = new UserSignupDto();
        userSignupDto.setEmail("foo@bar.com");
        userSignupDto.setPassword("Pass word1");
        userSignupDto.setConfirmPassword("Pass word1");

        //run
        Set<ConstraintViolation<UserSignupDto>> violations = validator.validate(userSignupDto);
        String message = violations.iterator().next().getMessage();

        //assert
        assertEquals("Password must not contain spaces", message);
	}
	
	@DisplayName("when password and confirmed password do not match then validation fails")
	@Test
	void validatePasswordTest8() {
		//given
    	UserSignupDto userSignupDto = new UserSignupDto();
        userSignupDto.setEmail("foo@bar.com");
        userSignupDto.setPassword("Password1");
        userSignupDto.setConfirmPassword("Password12");

        //run
        Set<ConstraintViolation<UserSignupDto>> violations = validator.validate(userSignupDto);
        String message = violations.iterator().next().getMessage();

        //assert
        assertEquals("Passwords do not match", message);
	}
	
}
