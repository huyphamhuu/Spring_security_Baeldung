package com.example.demo.validation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.demo.validation.ValidEmail;
public class EmailValidator implements ConstraintValidator<ValidEmail,String>{
    private Pattern pattern;
    private Matcher matcher;
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Override
    public void initialize(final ValidEmail constraintAnnotation) {
    }
    @Override
    public boolean isValid(final String username, final ConstraintValidatorContext context) {
        return (validateEmail(username));
    }
    public boolean validateEmail(final String username){
        pattern=Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(username);
        return matcher.matches();
    }
}
// EV implement tu ConstrainValidator request 2 parameterr (the annotation type and the type of object
// this will apply (here is string)