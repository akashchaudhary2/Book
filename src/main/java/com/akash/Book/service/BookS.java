package com.akash.Book.service;

import com.akash.Book.model.Book;
import com.akash.Book.model.PatchBookRequest;

import java.util.List;
import java.util.Optional;

public interface BookS {
    void create(Book book);

    List<Book> getBooks();

    void update(Book book, PatchBookRequest request);

    Optional<Book> getBook(Long id);

    void delete(Long id);

    List<Book> priceLowestToHighest();

    List<Book> bookWithinPriceRange(int x);
}
