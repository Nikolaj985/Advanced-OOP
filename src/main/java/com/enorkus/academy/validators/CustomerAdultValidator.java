package com.enorkus.academy.validators;

import com.enorkus.academy.exception.CustomerNotAdultException;

import javax.xml.bind.ValidationException;

public class CustomerAdultValidator extends Validator<Integer>{
        @Override
    public void validate(Integer atribute, String message) throws ValidationException {
        if (atribute < 18) {
            throw new ValidationException(message);
        }
    }
}
