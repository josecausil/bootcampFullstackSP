package com.sophos.challenge.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int idAccount;
    private String TypeAccount;
    private int accountNumber;
    private String accountStatus;
    private int balance;
    private int availableBalance;
    private String exemptGMF;
    private Date createDate;
    private String createUser;
    private Date modificationDate;
    private String modificationUser;



    
    public Product(int idAccount, String typeAccount, int accountNumber, String accountStatus, int balance,
            int availableBalance, String exemptGMF, Date createDate, String createUser, Date modificationDate,
            String modificationUser) {
        this.idAccount = idAccount;
        TypeAccount = typeAccount;
        this.accountNumber = accountNumber;
        this.accountStatus = accountStatus;
        this.balance = balance;
        this.availableBalance = availableBalance;
        this.exemptGMF = exemptGMF;
        this.createDate = createDate;
        this.createUser = createUser;
        this.modificationDate = modificationDate;
        this.modificationUser = modificationUser;
    }

    public int getIdAccount() {
        return idAccount;
    }
    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }
    public String getTypeAccount() {
        return TypeAccount;
    }
    public void setTypeAccount(String typeAccount) {
        TypeAccount = typeAccount;
    }
    public int getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    public String getAccountStatus() {
        return accountStatus;
    }
    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
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
    public String getExemptGMF() {
        return exemptGMF;
    }
    public void setExemptGMF(String exemptGMF) {
        this.exemptGMF = exemptGMF;
    }
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public String getCreateUser() {
        return createUser;
    }
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
    public Date getModificationDate() {
        return modificationDate;
    }
    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }
    public String getModificationUser() {
        return modificationUser;
    }
    public void setModificationUser(String modificationUser) {
        this.modificationUser = modificationUser;
    }




}
