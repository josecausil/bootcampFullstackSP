package com.sophos.challenge.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int idTransaction;
    private Date transactionDate;
    private String typeTransaction;
    private String Description;
    private int valueTransfer;
    private String movementType;
    private int balance;
    private int availableBalance;


    
    public Transaction(int idTransaction, Date transactionDate, String typeTransaction, String description,
            int valueTransfer, String movementType, int balance, int availableBalance) {
        this.idTransaction = idTransaction;
        this.transactionDate = transactionDate;
        this.typeTransaction = typeTransaction;
        Description = description;
        this.valueTransfer = valueTransfer;
        this.movementType = movementType;
        this.balance = balance;
        this.availableBalance = availableBalance;
    }
    public int getIdTransaction() {
        return idTransaction;
    }
    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }
    public Date getTransactionDate() {
        return transactionDate;
    }
    public void setTransactionDate(Date transactionDate) {
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


    
}
