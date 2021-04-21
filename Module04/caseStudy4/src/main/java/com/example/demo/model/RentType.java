package com.example.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "rent_type")
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rent_type_id",nullable = false)
    private int id;

    @Column(name = "rent_type_name",length = 45,nullable = false)
    private String name;

    @Column(name ="rent_type_cost" )
    private int cost;

    @OneToMany(mappedBy = "rentType",cascade = CascadeType.ALL)
    Set<Service> serviceList;

    public RentType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int rentTypeCost) {
        this.cost = rentTypeCost;
    }

    public Set<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(Set<Service> serviceList) {
        this.serviceList = serviceList;
    }
}
