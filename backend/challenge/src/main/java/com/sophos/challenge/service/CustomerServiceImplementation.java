package com.sophos.challenge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sophos.challenge.data.DateCalculator;
import com.sophos.challenge.entity.Customer;
import com.sophos.challenge.repository.CustomerRepository;

@Service
public class CustomerServiceImplementation implements CustomerService {
    
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer){
        boolean result = DateCalculator.adult(customer);
        if(result==true){
            return customerRepository.save(customer);
            
        }else{
            //se debe retornar error
            return null; 
        }
        
    }

    @Override
    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(int idCustomer){
        return customerRepository.findById(idCustomer);
    }

    public boolean deleteCustomerById(int idCustomer){

        
        return getCustomerById(idCustomer).map(customer ->{
            customerRepository.deleteById(idCustomer);
            return true;
            
        }).orElse(false);
    }



}
