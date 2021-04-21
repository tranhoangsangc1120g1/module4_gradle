package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "division")
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id",nullable = false)
    private Integer id;

     @Column(name = "division_name" ,nullable = false)
    private String name;

    @OneToMany(mappedBy = "division",cascade = CascadeType.ALL)
    List<Employee> employeeList;

    public Division() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
