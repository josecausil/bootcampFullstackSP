package com.sophos.challenge.entity;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.*;


@Entity
@Table(name = "product")
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAccount;

    private String typeAccount;
    private String accountNumber;
    private String accountStatus;
    private int balance;
    private int availableBalance;
    private boolean exemptGMF;
    private LocalDate createDate= LocalDate.now();
    private String createUser="Admin";
    private LocalDate modificationDate=LocalDate.now();
    private String modificationUser="Admin";

    @ManyToOne
    @JoinColumn(name = "idCustomer")
    private Customer customer;

 

    
    public Product() {
    }

   // public Product( String typeAccount,int balance,int availableBalance,boolean exemptGMF){

    //}


    public Product(int idAccount, String typeAccount, String accountNumber, String accountStatus, int balance,
            int availableBalance, boolean exemptGMF, LocalDate createDate, String createUser, LocalDate modificationDate,
            String modificationUser, Customer customer) {
        this.idAccount = idAccount;
        this.typeAccount = typeAccount;
        this.accountNumber = accountNumber;
        this.accountStatus = accountStatus;
        this.balance = balance;
        this.availableBalance = availableBalance;
        this.exemptGMF = exemptGMF;
        this.createDate = createDate;
        this.createUser = createUser;
        this.modificationDate = modificationDate;
        this.modificationUser = modificationUser;
        this.customer = customer;
    }

    public int getIdAccount() {
        return idAccount;
    }
    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }
    public String getTypeAccount() {
        return typeAccount;
    }
    public void setTypeAccount(String typeAccount) {
        this.typeAccount = typeAccount;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
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
    public boolean getExemptGMF() {
        return exemptGMF;
    }
    public void setExemptGMF(boolean exemptGMF) {
        this.exemptGMF = exemptGMF;
    }
    public LocalDate getCreateDate() {
        return createDate;
    }
    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }
    public String getCreateUser() {
        return createUser;
    }
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
    public LocalDate getModificationDate() {
        return modificationDate;
    }
    public void setModificationDate(LocalDate modificationDate) {
        this.modificationDate = modificationDate;
    }
    public String getModificationUser() {
        return modificationUser;
    }
    public void setModificationUser(String modificationUser) {
        this.modificationUser = modificationUser;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    
  

}
