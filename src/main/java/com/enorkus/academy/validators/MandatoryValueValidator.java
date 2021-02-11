package com.enorkus.academy.validators;

import com.enorkus.academy.exception.MandatoryValueMissingException;
import org.springframework.util.StringUtils;

import javax.xml.bind.ValidationException;

public class MandatoryValueValidator extends Validator<String> {

    @Override
    public void validate(String atribute, String message) {
        if (StringUtils.isEmpty(atribute.trim())) {
            throw new ValidationException(message);
        }
    }


}

