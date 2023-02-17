package com.example.Book.service;

import com.example.Book.model.Book;
import com.example.Book.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;

public interface BooksService {

    void create(Book book);
}
