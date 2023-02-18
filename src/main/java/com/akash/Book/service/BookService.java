package com.akash.Book.service;

import com.akash.Book.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getBooks();

    void create(Book book);

    void delete(Long id);

    Optional<Book> cheapestBook();
}
