package dev.a2.onlinestore.validation;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PasswordValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(ValidPassword.List.class)
public @interface ValidPassword {
	String pattern();
	String message();
	Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    
    @Target({ ElementType.FIELD })
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
    	ValidPassword[] value();
    }
}
