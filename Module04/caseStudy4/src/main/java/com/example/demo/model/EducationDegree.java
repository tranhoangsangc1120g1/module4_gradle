package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "education_degree")
public class EducationDegree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "education_degree_id", nullable = false)
    private Integer id;

    @Column(name = "education_degree_name", length = 45, nullable = false)
    private String name;

     @OneToMany(mappedBy = "educationDegree",cascade = CascadeType.ALL)
    List<Employee> employeeList;

    public EducationDegree() {
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
