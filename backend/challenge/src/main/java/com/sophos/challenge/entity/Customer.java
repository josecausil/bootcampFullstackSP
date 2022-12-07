package com.sophos.challenge.entity;


import java.time.LocalDate;

import javax.persistence.*;


@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCustomer;
    
    private String identificationType;
    private int identificationNumber;
    private String names;
    private String lastName;
    private String email;
    private LocalDate birthDate;
    private LocalDate createDate;
    private String createUser;
    private LocalDate modificationDate;
    private String modificationUser;


    
    
    public Customer() {
    }

    public Customer( String identificationType, int identificationNumber, String names, String lastName,
    String email, LocalDate birthDate){

      
        this.idCustomer = 0;
        this.identificationType = identificationType;
        this.identificationNumber = identificationNumber;
        this.names = names;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
        this.createDate = LocalDate.now();
        this.createUser = "Admin";
        this.modificationDate = LocalDate.now();
        this.modificationUser = "Admin";


    }
    
    public Customer(int idCustomer, String identificationType, int identificationNumber, String names, String lastName,
            String email, LocalDate birthDate, LocalDate createDate, String createUser, LocalDate modificationDate,
            String modificationUser) {
        this.idCustomer = idCustomer;
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
    
    @Column(name = "id_customer", nullable = false)
    public int getIdCustomer() {
        return idCustomer;
    }
    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    @Column(name = "identification_type", nullable = false)
    public String getIdentificationType() {
        return identificationType;
    }
    public void setIdentificationType(String identificationType) {
        this.identificationType = identificationType;
    }

    @Column(name = "identification_number", nullable = false)
    public int getIdentificationNumber() {
        return identificationNumber;
    }
    public void setIdentificationNumber(int identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    @Column(name = "names", nullable = false)
    public String getNames() {
        return names;
    }
    public void setNames(String names) {
        this.names = names;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "birth_date", nullable = false)
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Column(name = "create_date", nullable = false)
    public LocalDate getCreateDate() {
        return createDate;
    }
    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    @Column(name = "create_user", nullable = false)
    public String getCreateUser() {
        return createUser;
    }
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Column(name = "modification_date", nullable = false)
    public LocalDate getModificationDate() {
        return modificationDate;
    }
    public void setModificationDate(LocalDate modificationDate) {
        this.modificationDate = modificationDate;
    }

    @Column(name = "modification_user", nullable = false)
    public String getModificationUser() {
        return modificationUser;
    }
    public void setModificationUser(String modificationUser) {
        this.modificationUser = modificationUser;
    }


   



    
}
