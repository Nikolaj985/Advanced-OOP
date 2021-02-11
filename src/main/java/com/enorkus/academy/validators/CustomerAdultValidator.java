package com.enorkus.academy.validators;

import com.enorkus.academy.exception.ValidationException;

public class CustomerAdultValidator extends Validator<Integer> {
    @Override
    public void validate(Integer atribute, String message) {
        if (atribute < 18) {
            throw new ValidationException(message);
        }
    }
}
