package com.sophos.challenge.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sophos.challenge.entity.Transaction;
import com.sophos.challenge.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping("{id_Product}")
    public ResponseEntity<List<Transaction>> getAllTransactionByIdProduct (@PathVariable("id_Product")int id_Product){
        return ResponseEntity.ok(transactionService.findAllByProduct(id_Product));
    }

    
    @PostMapping
    public ResponseEntity<Transaction> createProduct(@RequestBody Transaction transaction){   
         try {                  
               Optional<Transaction> TransactionData =  transactionService.getTransactionById(transaction.getIdTransaction());
               return new ResponseEntity<>(transactionService.createTransaction(transaction), HttpStatus.CREATED); 
         } catch (Exception e) {
               return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED); 
         }              
    }


    
}
