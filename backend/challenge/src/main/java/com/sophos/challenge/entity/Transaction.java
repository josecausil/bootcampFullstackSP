package com.sophos.challenge.entity;


import java.time.LocalDate;

import javax.persistence.*;


@Entity
@Table(name = "transaction")
public class Transaction {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idTransaction;

    private LocalDate transactionDate;
    private String typeTransaction;
    private String Description;
    private int valueTransfer;
    private String movementType;
    private int balance;
    private int availableBalance;

    @ManyToOne
    @JoinColumn(name = "idAccount")
    private Product product;


    
    public Transaction() {
    }
    
    public Transaction(int idTransaction, LocalDate transactionDate, String typeTransaction, String description,
            int valueTransfer, String movementType, int balance, int availableBalance, Product product) {
        this.idTransaction = idTransaction;
        this.transactionDate = transactionDate;
        this.typeTransaction = typeTransaction;
        Description = description;
        this.valueTransfer = valueTransfer;
        this.movementType = movementType;
        this.balance = balance;
        this.availableBalance = availableBalance;
        this.product = product;
    }
    public int getIdTransaction() {
        return idTransaction;
    }
    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }
    public LocalDate getTransactionDate() {
        return transactionDate;
    }
    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }
    public String getTypeTransaction() {
        return typeTransaction;
    }
    public void setTypeTransaction(String typeTransaction) {
        this.typeTransaction = typeTransaction;
    }
    public String getDescription() {
        return Description;
    }
    public void setDescription(String description) {
        Description = description;
    }
    public int getValueTransfer() {
        return valueTransfer;
    }
    public void setValueTransfer(int valueTransfer) {
        this.valueTransfer = valueTransfer;
    }
    public String getMovementType() {
        return movementType;
    }
    public void setMovementType(String movementType) {
        this.movementType = movementType;
    }
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
    public int getAvailableBalance() {
        return availableBalance;
    }
    public void setAvailableBalance(int availableBalance) {
        this.availableBalance = availableBalance;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


    
}
