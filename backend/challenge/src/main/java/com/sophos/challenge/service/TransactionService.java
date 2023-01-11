package com.sophos.challenge.service;

import java.util.List;
import java.util.Optional;

import com.sophos.challenge.entity.Transaction;

public interface TransactionService {
    
  
    public List<Transaction> findAllByProduct(int idAccount);
    public Transaction createTransaction(Transaction transaction);
    public Optional<Transaction> getTransactionById(int idTransaction);
    
  
    

}
