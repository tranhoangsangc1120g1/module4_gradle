package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "contract")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id",nullable = false)
    private int contractId;

    @Column(name = "contract_start_date",nullable = false,length = 45)
    private String startDate;


    @Column(name = "contract_end_date",nullable = false,length = 45)
    private String endDate;

    @Column(name = "contract_deposit",nullable = false)
    private double deposit;


    @Column(name = "contract_total",nullable = false)
    private double total;

    @ManyToOne
    @JoinColumn(name = "employee_id",referencedColumnName = "employee_id",nullable = false)
    private Employee employee;


    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "customer_id",nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "service_id",referencedColumnName = "service_id",nullable = false)
    private Service service;

    @OneToMany(mappedBy = "contract",cascade = CascadeType.ALL)
    List<ContractDetails> contractDetailsList;


    public Contract() {
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<ContractDetails> getContractDetailsList() {
        return contractDetailsList;
    }

    public void setContractDetailsList(List<ContractDetails> contractDetailsList) {
        this.contractDetailsList = contractDetailsList;
    }
}
