package com.enorkus.academy.validators;

import com.enorkus.academy.coutrycode.CountryCode;
import com.enorkus.academy.exception.ValidationException;
import org.springframework.util.StringUtils;

public class CountryCodeValidator extends Validator<String> {
    @Override
    public void validate(String attribute, String message) {
        if (!StringUtils.isEmpty(attribute)) {
            throw new ValidationException(message);
        }
        if (!isCountryCodeValid(attribute)) {
            throw new ValidationException(message);
        }
    }
    private boolean isCountryCodeValid(String countryCode) {
        for (CountryCode c : CountryCode.values()) {
            if (c.name().equals(countryCode.toUpperCase())) {
                return true;
            }
        }
        return false;
    }
}
