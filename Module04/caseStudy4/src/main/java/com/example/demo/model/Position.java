package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "positions")
@Table
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="position_id",nullable = false)
    private  int positionId;

     @Column(name = "position_name",length = 45,nullable =  false)
    private String positionName;
    @OneToMany(mappedBy = "position",cascade = CascadeType.ALL)
    List<Employee> employeeList;

    public Position() {
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
