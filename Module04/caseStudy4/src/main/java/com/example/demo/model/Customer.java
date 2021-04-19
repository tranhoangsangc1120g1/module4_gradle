package com.example.demo.model;

import javax.persistence.*;

@Entity(name = "customer")
@Table
public class Customer {
    @Id
    @Column(name = "customer_id",nullable = false)
    private  String customerId;


    @Column(name = "customer_name" ,nullable = false)
    private String customerName;
    @Column(name = "customer_birthday" ,nullable = false)
    private String customerBirthday;
    @Column(name = "customer_gender" ,nullable = false)
    private  int customerGender;
    @Column(name = "customer_id_card" ,nullable = false)
    private String customerIdCard;
    @Column(name = "customer_phone" ,nullable = false)
    private String customerPhone;
    @Column(name = "customer_email" ,nullable = false)
    private String customerEmail;
    @Column(name = "customer_address" ,nullable = false)
    private String customerAddress;

//    foreign key(customer_type_id) references customer_type(customer_type_id) on update cascade on delete cascade,

    @ManyToOne
    @JoinColumn(name = "customer_type_id",referencedColumnName ="customer_type_id",nullable = false)
    private CustomerType customerType;

    public Customer() {
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customer_id) {
        this.customerId = customer_id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customer_name) {
        this.customerName = customer_name;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customer_birthday) {
        this.customerBirthday = customer_birthday;
    }

    public int getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(int customer_gender) {
        this.customerGender = customer_gender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customer_id_card) {
        this.customerIdCard = customer_id_card;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customer_phone) {
        this.customerPhone = customer_phone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customer_email) {
        this.customerEmail = customer_email;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customer_address) {
        this.customerAddress = customer_address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
