package com.example.baitap.model;

import org.springframework.context.annotation.Configuration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
@Configuration
public class Customer  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Thật trống trãi khi bạn không điền gì vào")
    @Size(min = 5, max = 45, message = "Từ 5 đên 45 con người còn chịu được , quá 45 thì chết con người ta à")
    private String firstName;


    @NotBlank(message = "Thật trống trãi khi bạn không điền gì vào")
    @Size(min = 5, max = 45, message = "Từ 5 đên 45 con người còn chịu được , quá 45 thì chết con người ta à")
    private String lastName;

    @Email(message = "abc@xxx.xxx")
    private String email;

    @NotNull(message = "điền vào để biết mà còn liên lạc")
    @Pattern(regexp = "0\\d{9}",message = "điền 0 trước rồi thích điền gì thì điền")
    private String phoneNumber;

    @Min(value = 18, message = "Đủ tuổi để vấp ngã rồi")
    @Max(value = 150, message = "Sống quá lâu rồi đó")
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
