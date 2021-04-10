package com.example.muonsach.repository;

import com.example.muonsach.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepo  extends JpaRepository<Book,Integer> {

}
