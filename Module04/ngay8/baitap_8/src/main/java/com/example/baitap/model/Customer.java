package com.example.baitap.model;

import org.springframework.context.annotation.Configuration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class Customer  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Can not be null")
    @Size(min = 5, max = 45, message = "more than 5 characters , less than 45 characters ")
    private String firstName;


    @NotBlank(message = "Can not be null")
    @Size(min = 5, max = 45, message = "more than 5 characters , less than 45 characters")
    private String lastName;

    @Email(message = "abc@xxx.xxx")
    private String email;

    @NotNull(message = "Can not be null")
    @Pattern(regexp = "0\\d{9}",message = "Starting with 0 and 9 numbers")
    private String phoneNumber;

    @Min(value = 18, message = " 18 years older")
    @Max(value = 150, message = "Less than 150 ys ")
    private double age;
    public Customer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }
}
