package com.example.demo.validation;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import com.example.demo.validation.EmailValidator;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ TYPE, FIELD, ANNOTATION_TYPE })
// define where the annotation can be used. Here can be used on fields, types and another annotations
@Retention(RUNTIME)
// define when the annotation will be ren. Here will be run in runtime

@Constraint(validatedBy = EmailValidator.class)
//@Constraint: Indicates that this annotation is a validation constraint and associates it with the EmailValidator.class,
// which contains the logic to perform the validation.
@Documented
//@Documented: Ensures that elements annotated with @ValidEmail are documented by the Javadoc tool.
public @interface ValidEmail {

    String message() default "Invalid Email";
    // SHow error

    Class<?>[] groups() default {};
    // Group dependence

    Class<? extends Payload>[] payload() default {};
}
