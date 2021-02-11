package com.enorkus.academy.services;

import com.enorkus.academy.entity.Customer;
import com.enorkus.academy.repository.MemoryCustomerRepository;
import com.enorkus.academy.validators.CustomerValidator;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;

public class CustomerService {
    private MemoryCustomerRepository memoryCustomerRepository;
    private CustomerValidator customerValidator;

    public CustomerService() {
        memoryCustomerRepository = new MemoryCustomerRepository();
        customerValidator = new CustomerValidator();
    }

    public List<Customer> fetchCustomers() {
        return memoryCustomerRepository.findAll();
    }

    public void insertCustomer(@RequestBody Customer customer) {
        customerValidator.validateCustomer(customer);
        Customer correctedCustomer = correctNaming(customer);
        memoryCustomerRepository.insert(correctedCustomer);
    }

    public void deleteCustomer(@PathVariable String customerId) {
        memoryCustomerRepository.deleteById(customerId);
    }

    private Customer correctNaming(Customer customer) {
        String nameFirstUp = firstToUpper(customer.getFirstName());
        String surnameFirstUp = firstToUpper(customer.getLastName());
        String personalNumberWithDash = dashInPersonalNumber(customer.getPersonalNumber());
        Customer correctedCustumer = new Customer.CustomerBuilder(nameFirstUp, surnameFirstUp, personalNumberWithDash).
                middleName(customer.getMiddleName()).age(customer.getAge()).city(customer.getCity()).
                countryCode(customer.getCountryCode()).monthlyIncome(customer.getMonthlyIncome()).employer(customer.getEmployer()).
                gender(customer.getGender()).maritalStatus(customer.getMaritalStatus()).build();
        return correctedCustumer;
    }

    private String firstToUpper(String text) {
        if (text.equals("") || text.equals(null)) {
            return text;
        }
        String lowerCase = text.toLowerCase();
        return lowerCase.substring(0, 1).toUpperCase() + lowerCase.substring(1);
    }

    private String dashInPersonalNumber(String personalNumber) {
        if (personalNumber.length() < 4) {
            return personalNumber;
        }
        if (personalNumber.length() == 4) {
            return personalNumber + '-';
        }
        if (personalNumber.charAt(4) == '-') {
            return personalNumber;
        }
        return personalNumber.substring(0, 4) + '-' + personalNumber.substring(4);
    }
}