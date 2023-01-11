package com.sophos.challenge.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sophos.challenge.entity.Product;
import com.sophos.challenge.entity.Transaction;
import com.sophos.challenge.repository.ProductRepository;
import com.sophos.challenge.repository.TransactionRepository;

@Service
public class TransactionServiceImplementation implements TransactionService {
    

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    ProductRepository productRepository;



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
    public Transaction createTransactionTransfer(Transaction transactionOrigin,Transaction transactionDestiny){
        transactionRepository.save(transactionDestiny);
        return transactionRepository.save(transactionOrigin);

    }

    @Override
    public Optional<Transaction> getTransactionById(int idTransaction) {
        return transactionRepository.findById(idTransaction);
    }

    @Override
    public Optional<Product> getProductById(int idAccount) {
        return productRepository.findById(idAccount);
    }

}
