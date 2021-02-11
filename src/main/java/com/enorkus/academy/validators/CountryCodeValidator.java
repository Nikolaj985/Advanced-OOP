package com.enorkus.academy.validators;

import com.enorkus.academy.coutrycode.CountryCode;
import com.enorkus.academy.exception.InvalidCountryCodeException;
import org.springframework.util.StringUtils;

import javax.xml.bind.ValidationException;

public class CountryCodeValidator extends Validator<String>{
    @Override
    public void validate(String atribute, String message)  {
        if (!checkCountryCode(atribute)) {
            throw new ValidationException(message);
        }
    }
    private boolean checkCountryCode(String countryCode) {
        if (StringUtils.isEmpty(countryCode)) {
            return true;
        }
        for (CountryCode c : CountryCode.values()) {
            if (c.name().equals(countryCode)) {
                return true;
            }
        }
        return false;
    }
}
