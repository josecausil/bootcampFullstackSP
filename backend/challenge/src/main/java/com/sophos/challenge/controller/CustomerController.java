package com.sophos.challenge.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sophos.challenge.data.DateCalculator;
import com.sophos.challenge.entity.Customer;
import com.sophos.challenge.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getCustumer(){
        return new ResponseEntity<>(customerService.getAllCustomer(), HttpStatus.OK);
    }

    @GetMapping("{idCustomer}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("idCustomer")int idCustomer){
        return customerService.getCustomerById(idCustomer)
                .map(customer -> new ResponseEntity<>(customer, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("{idCustomer}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable ("idCustomer") int idCustomer, @RequestBody Customer item){
     Optional<Customer> CustomerData =  customerService.getCustomerById(idCustomer);
     if(CustomerData.isPresent()){
        Customer _customer = CustomerData.get();
        _customer.setNames(item.getNames());
        _customer.setLastName(item.getLastName());
        _customer.setEmail(item.getEmail());
        _customer.setBirthDate(item.getBirthDate());
        _customer.setModificationDate(LocalDate.now());
        return new ResponseEntity<>(customerService.createCustomer(_customer), HttpStatus.OK);
     }else{
        return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
     }
  
   
  }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        boolean result = DateCalculator.adult(customer);
        if(result==true){

            try {
                return new ResponseEntity<>(customerService.createCustomer(customer), HttpStatus.CREATED);    
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
            }
        }else{
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }        
       
    }


    @DeleteMapping("/{idCustomer}")
    public ResponseEntity deleteCustomerById(@PathVariable("idCustomer") int idCustomer){
        if(customerService.deleteCustomerById(idCustomer)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    
}
