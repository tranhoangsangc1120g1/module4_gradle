package com.example.demo.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity(name = "service_type")
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_type_id",nullable = false)
    private int serviceTypeId;

    @Column(name = "service_type_name",length = 45,nullable = false)
    private String serviceTypeName;

    @OneToMany(mappedBy = "serviceType",cascade = CascadeType.ALL)
    List<Service> serviceList;

    public ServiceType() {
    }

    public int getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(int serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }

    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }
}
