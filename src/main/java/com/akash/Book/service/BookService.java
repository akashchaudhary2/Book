package com.akash.Book.service;

import com.akash.Book.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getBooks();

    void create(Book book);

    void delete(Long id);


    List<Book> priceLowestToHighest();

    List<Book> priceHighestToLowest();
}
