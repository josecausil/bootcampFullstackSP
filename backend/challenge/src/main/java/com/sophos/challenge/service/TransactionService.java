package com.sophos.challenge.service;

import java.util.List;

import com.sophos.challenge.entity.Transaction;

public interface TransactionService {
    
  
    public List<Transaction> findAllByProduct(int idAccount);
    public Transaction createTransaction(Transaction transaction);
    
  
    

}
