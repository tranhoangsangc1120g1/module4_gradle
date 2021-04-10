package com.example.muonsach.service.impl;

import com.example.muonsach.model.Book;
import com.example.muonsach.repository.IBookRepo;
import com.example.muonsach.service.BookException;
import com.example.muonsach.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    IBookRepo iBookRepo;

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return iBookRepo.findAll(pageable);
    }

    @Override
    public Book findById(int id) {
        return iBookRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Book book) {
        iBookRepo.save(book);
    }

    @Override
    public void saveBorrowed( int id ) throws BookException {
        Book book = iBookRepo.findById(id).orElse(null);
        if (book.getAmount() > 0) {
            book.setAmount(book.getAmount() - 1);
            iBookRepo.save(book);
        }else {
            throw new BookException();
        }
    }

    @Override
    public void saveReturn(int id) {
        Book book = iBookRepo.findById(id).orElse(null);
        book.setAmount(book.getAmount()+1);
        iBookRepo.save(book);
    }

}
