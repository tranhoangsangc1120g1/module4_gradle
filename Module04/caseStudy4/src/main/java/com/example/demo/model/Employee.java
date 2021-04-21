package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id",nullable = false)
    private Integer id;

    @Column(name = "employee_name",nullable = false,length = 45)
    private String name;

    @Column(name = "employee_birthday",length = 45,nullable = false)
    private String birthday;

    @Column(name = "employee_id_card",length = 45,nullable = false)
    private String idCard;

    @Column(name = "employee_salary",nullable = false)
    private double salary;
    @Column(name = "employee_phone",length = 45,nullable = false)
    private String phoneNumber;

    @Column(name = "employee_email",length = 45,nullable = false)
    private String email;

    @Column(name = "employee_address",length = 45,nullable = false)
    private String address;

  @ManyToOne
  @JoinColumn(name = "position_id",referencedColumnName = "position_id",nullable = false)
    private Position position;

  @ManyToOne
  @JoinColumn(name = "division_id",referencedColumnName = "division_id",nullable = false)
    private Division division;

  @ManyToOne
  @JoinColumn(name = "education_degree_id",referencedColumnName = "education_degree_id",nullable = false)
  private EducationDegree educationDegree;

  @OneToOne
  @JoinColumn(name = "username",referencedColumnName = "username",nullable = false)
    private User user;

  @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
  List<Contract> contractList;

    public Employee() {
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

