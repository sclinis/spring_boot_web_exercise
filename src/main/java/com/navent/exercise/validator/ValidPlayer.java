package com.navent.exercise.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = PlayerValidatorContraint.class)
public @interface ValidPlayer {
    String message() default "Invalid Player";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
