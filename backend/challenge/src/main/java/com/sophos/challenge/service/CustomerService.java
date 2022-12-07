package com.sophos.challenge.service;

import java.util.List;
import java.util.Optional;

import com.sophos.challenge.entity.Customer;

public interface CustomerService {


    public Customer createCustomer(Customer customer);
    public List<Customer> getAllCustomer();
    public Optional<Customer> getCustomerById(int idCustomer);
    public boolean deleteCustomerById(int idCustomer);

    
}
