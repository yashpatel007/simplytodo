package com.simplytodo.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
public @interface Password {
    String message() default "Invalid password. Password must be at least 8 characters long, contain an uppercase letter, a number, and a special character.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}


