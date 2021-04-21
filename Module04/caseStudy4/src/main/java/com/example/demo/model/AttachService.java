package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "attach_service")
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="attach_service_id",nullable = false)
    private int id;

    @Column(name = "attach_service_name",nullable = false,length = 45)
    private String name;

    @Column(name = "attach_service_cost",nullable = false)
    private int cost;

    @Column(name = "attach_service_unit",nullable = false)
    private int unit;


    @Column(name = "attach_service_status",nullable = false)
    private String status;

    @OneToMany(mappedBy = "attachService",cascade = CascadeType.ALL)
    List<ContractDetails> contractDetailsList;

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

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ContractDetails> getContractDetailsList() {
        return contractDetailsList;
    }

    public void setContractDetailsList(List<ContractDetails> contractDetailsList) {
        this.contractDetailsList = contractDetailsList;
    }
}
