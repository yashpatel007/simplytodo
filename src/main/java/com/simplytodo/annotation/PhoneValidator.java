package com.simplytodo.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {
    @Override
    public boolean isValid(String phone, ConstraintValidatorContext constraintValidatorContext) {
        if(phone == null) {
            return false;
        }

        String pattern = "^\\+?1?[\\s-]?\\(?[2-9]\\d{2}\\)?[\\s-]?[2-9]\\d{2}[\\s-]?\\d{4}$";
        return phone.matches(pattern);
    }

    /*
    * The regular expression ^\\+?1?[\\s-]?\\(?[2-9]\\d{2}\\)?[\\s-]?[2-9]\\d{2}[\\s-]?\\d{4}$ matches strings that:
        ^\\+?1? start with an optional plus sign followed by an optional 1.
        [\\s-]? contain an optional space or hyphen.
        \\(?[2-9]\\d{2}\\)? contain an optional area code enclosed in parentheses.
        [\\s-]? contain an optional space or hyphen.
        [2-9]\\d{2} contain a three-digit exchange code that starts with a digit between 2 and 9.
        [\\s-]? contain an optional space or hyphen.
        \\d{4}$ end with a four-digit line number.
    * */
}
