package com.sophos.challenge.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sophos.challenge.entity.Transaction;
import com.sophos.challenge.repository.TransactionRepository;

@Service
public class TransactionServiceImplementation implements TransactionService {
    

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public List<Transaction> findAllByProduct(int idAccount){
        List<Transaction>transactionResponse = new ArrayList<>();
        List<Transaction> transaction = transactionRepository.findAll();
        for(int i =0; i<transaction.size();i++){
            if(transaction.get(i).getProduct().getIdAccount()==idAccount){
                transactionResponse.add(transaction.get(i));
            }
        }

        return transactionResponse;
    }

    @Override
    public Transaction createTransaction(Transaction transaction){
        return transactionRepository.save(transaction);

    }

    @Override
    public Optional<Transaction> getTransactionById(int idTransaction) {
        return transactionRepository.findById(idTransaction);
    }
}
