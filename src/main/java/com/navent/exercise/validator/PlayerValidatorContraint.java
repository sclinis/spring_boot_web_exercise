package com.navent.exercise.validator;

import com.navent.exercise.rest.PlayerDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PlayerValidatorContraint implements ConstraintValidator<ValidPlayer, PlayerDTO> {

    @Override
    public void initialize(ValidPlayer constraintAnnotation) {
    }

    @Override
    public boolean isValid(PlayerDTO value, ConstraintValidatorContext context) {
        return (value.getName() != null);
    }
}
