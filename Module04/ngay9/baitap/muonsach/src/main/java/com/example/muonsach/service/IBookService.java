package com.example.muonsach.service;

import com.example.muonsach.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    Page<Book> findAll(Pageable pageable);
    Book findById(int id);
    void save (Book book);
    void saveBorrowed(int id) throws BookException;
    void saveReturn(int id);
}

