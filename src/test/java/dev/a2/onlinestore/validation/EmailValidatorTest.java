package dev.a2.onlinestore.validation;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

@DisplayName("Testing EmailValidator class")
public class EmailValidatorTest {
	
	private static EmailValidator emailValidator;
	
	@BeforeAll
	static void initAll() {
		emailValidator = new EmailValidator();
	}
	
	@DisplayName("when email empty then return false")
	@Test
	void validateEmailTest1() {
		//given
        String input = "";

        //run
        boolean result = emailValidator.validateEmail(input);

        //assert
        assertFalse(result);
	}
	
	@DisplayName("when email has no @ character then return false")
	@Test
	void validateEmailTest2() {
		//given
        String input = "Abc.example.com";

        //run
        boolean result = emailValidator.validateEmail(input);

        //assert
        assertFalse(result);
	}
	
	@DisplayName("when email has more than one @ character then return false")
	@Test
	void validateEmailTest3() {
		//given
        String input = "A@b@c@example.com";

        //run
        boolean result = emailValidator.validateEmail(input);

        //assert
        assertFalse(result);
	}
	
	@DisplayName("when email has special outside quotation marks then return false")
	@Test
	void validateEmailTest4() {
		//given
        String input = "a\"b(c)d,e:f;g<h>i[j\\k]l@example.com";

        //run
        boolean result = emailValidator.validateEmail(input);

        //assert
        assertFalse(result);
	}
	
	@DisplayName("when email has quoted strings without dot separation then return false")
	@Test
	void validateEmailTest5() {
		//given
        String input = "just\"not\"right@example.com";

        //run
        boolean result = emailValidator.validateEmail(input);

        //assert
        assertFalse(result);
	}
	
	@DisplayName("when email has escaped spaces, quotes, and backslashes outside quotation marks then return false")
	@Test
	void validateEmailTest6() {
		//given
        String input = "this\\ still\\\"not\\\\allowed@example.com";

        //run
        boolean result = emailValidator.validateEmail(input);

        //assert
        assertFalse(result);
	}
	
	@DisplayName("when email has double dot before @ then return false")
	@Test
	void validateEmailTest8() {
		//given
        String input = "ohn..doe@example.com";

        //run
        boolean result = emailValidator.validateEmail(input);

        //assert
        assertFalse(result);
	}
	
	@DisplayName("when email has double dot after @ then return false")
	@Test
	void validateEmailTest9() {
		//given
        String input = "john.doe@example..com";

        //run
        boolean result = emailValidator.validateEmail(input);

        //assert
        assertFalse(result);
	}
	
	@DisplayName("when email is valid then return true")
	@Test
	void validateEmailTest10() {
		//given
        String input = "foo@bar.com";

        //run
        boolean result = emailValidator.validateEmail(input);

        //assert
        assertTrue(result);
	}

}
