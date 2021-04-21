package com.example.demo.service.impl;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepo;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;


    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepo.findAll(pageable);
    }

    @Override
    public Employee findById(int id) {
        return employeeRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Employee employee) {
        employeeRepo.save(employee);
    }

    @Override
    public void remove(int id) {
        employeeRepo.deleteById(id);
    }

    @Override
    public Page<Employee> searchByName(String name, Pageable pageable) {
        return employeeRepo.findByNameContaining(name,pageable);
    }
}
