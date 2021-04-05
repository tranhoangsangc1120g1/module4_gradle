package com.thuchanh6.thuchanh6.repositoy;

import com.thuchanh6.thuchanh6.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICusRepo extends JpaRepository<Customer,Integer> {
}
