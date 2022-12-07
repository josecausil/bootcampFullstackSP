package com.sophos.challenge.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestParam String identificationType, 
                                                   @RequestParam int identificationNumber,
                                                   @RequestParam String names, 
                                                   @RequestParam String lastName,
                                                   @RequestParam String email,
                                                   @RequestParam LocalDate birthDate){
        Customer customer = new Customer(  identificationType,  identificationNumber,  names,  lastName,
         email,  birthDate);
        System.out.println("prueba1");
            Customer saveItem = customerService.createCustomer(customer);
            return new ResponseEntity<>(saveItem, HttpStatus.CREATED);
            
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
