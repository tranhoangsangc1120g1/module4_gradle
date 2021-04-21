package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "customer")
@Table
public class Customer {
    @Id
    @Column(name = "customer_id", nullable = false, length = 45)
    private String id;


    @Column(name = "customer_name", nullable = false, length = 45)
    private String name;
    @Column(name = "customer_birthday", nullable = false, length = 45)
    private String birthday;
    @Column(name = "customer_gender", nullable = false)
    private int gender;
    @Column(name = "customer_id_card", nullable = false, length = 45)
    private String idCard;
    @Column(name = "customer_phone", nullable = false, length = 45)
    private String phoneNumber;
    @Column(name = "customer_email", nullable = false, length = 45)
    private String email;
    @Column(name = "customer_address", nullable = false, length = 45)
    private String address;

    @ManyToOne
    @JoinColumn(name = "customer_type_id", referencedColumnName = "customer_type_id", nullable = false)
    private CustomerType customerType;

    @OneToMany(mappedBy ="customer",cascade = CascadeType.ALL)
    List<Contract> contractList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

}

