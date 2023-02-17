package com.example.Book.service;

import com.example.Book.model.Book;
import com.example.Book.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Class1 implements BooksService {
    @Autowired
    private BookRepo bookRepo;

    @Override
    public void create(Book book) {
        bookRepo.save(book);
    }
}
