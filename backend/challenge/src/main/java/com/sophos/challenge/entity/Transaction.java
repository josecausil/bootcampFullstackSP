package com.sophos.challenge.entity;


import java.time.LocalDate;

import javax.persistence.*;


@Entity
@Table(name = "transaction")
public class Transaction {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idTransaction;

    private LocalDate transactionDate= LocalDate.now();
    private String typeTransaction;
    private String description;
    private int valueTransfer;
    private String movementType; //credit or debit
    private int balance;
    private int availableBalance;
    private int idReceptionAccount;

    @ManyToOne
    @JoinColumn(name = "idAccount")
    private Product product;


    
    public Transaction() {
    }
    
    public Transaction(int idTransaction, LocalDate transactionDate, String typeTransaction, String description,
            int valueTransfer, String movementType, int balance, int availableBalance, int idReceptionAccount, Product product) {
        this.idTransaction = idTransaction;
        this.transactionDate = transactionDate;
        this.typeTransaction = typeTransaction;
        this.description = description;
        this.valueTransfer = valueTransfer;
        this.movementType = movementType;
        this.balance = balance;
        this.availableBalance = availableBalance;
        this.idReceptionAccount= idReceptionAccount;
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
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
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

    public int getIdReceptionAccount() {
        return idReceptionAccount;
    }

    public void setIdReceptionAccount(int idReceptionAccount) {
        this.idReceptionAccount = idReceptionAccount;
    }


    
    
}
