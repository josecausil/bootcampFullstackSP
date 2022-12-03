package com.sophos.challenge.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String identificationType;
    private int identificationNumber;
    private String names;
    private String lastName;
    private String email;
    private Date birthDate;
    private String createDate;
    private String createUser;
    private Date modificationDate;
    private String modificationUser;


    
    public Customer(int id, String identificationType, int identificationNumber, String names, String lastName,
            String email, Date birthDate, String createDate, String createUser, Date modificationDate,
            String modificationUser) {
        this.id = id;
        this.identificationType = identificationType;
        this.identificationNumber = identificationNumber;
        this.names = names;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
        this.createDate = createDate;
        this.createUser = createUser;
        this.modificationDate = modificationDate;
        this.modificationUser = modificationUser;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getIdentificationType() {
        return identificationType;
    }
    public void setIdentificationType(String identificationType) {
        this.identificationType = identificationType;
    }
    public int getIdentificationNumber() {
        return identificationNumber;
    }
    public void setIdentificationNumber(int identificationNumber) {
        this.identificationNumber = identificationNumber;
    }
    public String getNames() {
        return names;
    }
    public void setNames(String names) {
        this.names = names;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public String getCreateDate() {
        return createDate;
    }
    public void setCreateDate(String createDate) {
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
