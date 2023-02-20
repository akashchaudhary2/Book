package com.akash.Book.service;

import com.akash.Book.model.Book;

import java.util.List;

public interface BookS {
    List<Book> getBooks();

    void create(Book book);

    void delete(Long id);

    List<Book> priceLowestToHighest();

    List<Book> bookWithinPriceRange(int x);
}
