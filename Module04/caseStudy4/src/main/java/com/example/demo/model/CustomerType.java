package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "customer_type")
@Table
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_type_id",nullable = false)
    private int customerTypeId;

    @Column(name = "customer_type_name",nullable = false)
    private String customerTypeName;

    @OneToMany(mappedBy = "customerType",cascade = CascadeType.ALL)
     List<Customer> customerList;

    public CustomerType() {
    }

    public int getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(int customer_type_id) {
        this.customerTypeId = customer_type_id;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customer_type_name) {
        this.customerTypeName = customer_type_name;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
