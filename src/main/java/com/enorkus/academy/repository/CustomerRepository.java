package com.enorkus.academy.repository;

import com.enorkus.academy.entity.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface CustomerRepository {

    static final List<Customer> customers = new ArrayList<>();

    public List<Customer> findAll();

    public void insert(Customer customer);

    public void deleteById(String customerId);
}
