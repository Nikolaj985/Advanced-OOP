package com.enorkus.academy.validators;

import com.enorkus.academy.entity.Customer;

import javax.xml.bind.ValidationException;

public class CustomerValidator {



    public void validateCustomer(Customer customer)  {
        MandatoryValueValidator mandatoryValueValidator = new MandatoryValueValidator();
        mandatoryValueValidator.validate(customer.getFirstName(),"First name is mandatory!");
        mandatoryValueValidator.validate(customer.getLastName(), "Last name is mandatory!");
        mandatoryValueValidator.validate(customer.getPersonalNumber(), "Personal number is mandatory!");

        CustomerAdultValidator customerAdultValidator = new CustomerAdultValidator();
        customerAdultValidator.validate(customer.getAge(),"Customer must be 18 or older!");

        CountryCodeValidator countryCodeValidator = new CountryCodeValidator();
        countryCodeValidator.validate(customer.getCountryCode(), "Invalid country code!");
    }


}
