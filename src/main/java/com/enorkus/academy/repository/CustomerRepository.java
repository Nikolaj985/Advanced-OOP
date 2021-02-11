package com.enorkus.academy.repository;

import com.enorkus.academy.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public interface CustomerRepository {

    static final List<Customer> customers = new ArrayList<>();

    public List<Customer> findAll();

    public void insert(Customer customer);

    public void deleteById(String customerId);
}
