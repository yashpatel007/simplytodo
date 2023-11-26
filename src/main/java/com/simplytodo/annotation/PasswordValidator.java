package com.simplytodo.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, String> {
    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        // Your custom password validation logic here
        if (password == null) {
            return false;
        }
        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
        return password.matches(pattern);
    }

    //*
    // The regular expression ^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$ matches strings that:
    //
    //(?=.*[0-9]) contain at least one digit.
    //(?=.*[a-z]) contain at least one lowercase letter.
    //(?=.*[A-Z]) contain at least one uppercase letter.
    //(?=.*[@#$%^&+=!]) contain at least one special character.
    //(?=\\S+$) do not contain any whitespace.
    //{8,} are at least 8 characters long.
    // *//
}
