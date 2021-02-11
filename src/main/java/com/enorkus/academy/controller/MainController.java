package com.enorkus.academy.controller;

import com.enorkus.academy.entity.Customer;
import com.enorkus.academy.repository.CustomerRepository;
import com.enorkus.academy.repository.MemoryCustomerRepository;
import com.enorkus.academy.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    private CustomerService customerService;

    public MainController() {
        customerService = new CustomerService();
    }

    @RequestMapping("/customer/all")
    public List<Customer> fetchCustomers() {
        return customerService.fetchCustomers();
    }

    @PostMapping("/customer/insert")
    public void insertCustomer(@RequestBody Customer customer) throws ValidationException {
        customerService.insertCustomer(customer);
    }

    @DeleteMapping("/customer/delete/{customerId}")
    public void deleteCustomer(@PathVariable String customerId) {
        customerService.deleteCustomer(customerId);
    }
}