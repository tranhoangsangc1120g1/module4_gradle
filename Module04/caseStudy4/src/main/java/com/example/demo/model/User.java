package com.example.demo.model;

import javax.persistence.*;

@Entity(name = "users")
public class User {

    @Id
    @Column(name = "username", nullable = false)
    private String userName;

    @Column(name = "passwords", nullable = false)
    private String passWords;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Employee employee;

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWords() {
        return passWords;
    }

    public void setPassWords(String passWords) {
        this.passWords = passWords;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
