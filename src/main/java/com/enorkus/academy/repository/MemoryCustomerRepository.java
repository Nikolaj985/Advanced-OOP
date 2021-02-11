package com.enorkus.academy.repository;

import com.enorkus.academy.entity.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemoryCustomerRepository implements CustomerRepository{

    static final List<Customer> customers = new ArrayList<>();

    public List<Customer> findAll() {
        return customers;
    }

    public void insert(Customer customer) {
        customer.setId(customer.toString());
        customers.add(customer);
    }

    public void deleteById(String customerId) {
        Optional<Customer> customerToDelete = customers.stream()
                .filter(customer -> customer.getId().equals(customerId))
                .findFirst();
        customerToDelete.ifPresent(customers::remove);
    }
}
