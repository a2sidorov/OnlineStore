package dev.a2.onlinestore.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {
    private ValidPassword validPassword;
    
    @Override
    public void initialize(final ValidPassword validPassword) {
    	this.validPassword = validPassword;
    }

    @Override
    public boolean isValid(final String password, final ConstraintValidatorContext context) {
        return (validatePassword(password));
    }

    boolean validatePassword(final String password) {
    	return password.matches(validPassword.pattern());
    }
}