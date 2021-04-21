package com.example.demo.service;


import com.example.demo.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable);
    Employee findById(int id);
    void save(Employee user);
    void remove(int id);
    Page<Employee> searchByName(String name , Pageable pageable);

}
