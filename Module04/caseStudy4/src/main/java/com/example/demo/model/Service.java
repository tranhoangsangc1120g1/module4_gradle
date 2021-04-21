package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "service")
@Table
public class Service {
    @Id
    @Column(name = "service_id",length = 45,nullable = false)
    private String serviceId;

    @Column(name = "service_name",length = 45,nullable = false)
    private String serviceName;

    @Column(name = "service_area",nullable = false)
    private int serviceArea;

    @Column(name = "service_max_people",nullable = false)
    private int serviceMaxPeople;

    @Column(name = "service_cost")
    private double serviceCost;

    @Column(name = "standard_room",length = 45)
    private String standardRoom;

    @Column(name = "description_other_convenience",length = 45)
    private String descriptionOtherConvenience;

    @Column(name = "pool_area")
    private double poolArea;

    @Column(name = "number_of_floors")
    private int numberOfFloors;

    @ManyToOne
    @JoinColumn(name = "rent_type_id",referencedColumnName = "rent_type_id",nullable = false)
    private RentType rentType;

    @ManyToOne
    @JoinColumn(name = "service_type_id",referencedColumnName = "service_type_id",nullable = false)
    private ServiceType serviceType;

    @OneToMany(mappedBy = "service",cascade = CascadeType.ALL)
    List<Contract> contractList;

    public Service() {
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(int serviceArea) {
        this.serviceArea = serviceArea;
    }

    public int getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(int serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }
}
