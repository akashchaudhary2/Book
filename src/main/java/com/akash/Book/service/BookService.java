package com.akash.Book.service;

import com.akash.Book.model.Book;
import com.akash.Book.model.PatchBookRequest;

import java.util.List;
import java.util.Optional;

public interface BookService {
    void create(Book book);

    List<Book> getBooks();

    Optional<Book> getBook(Long id);

    void update(Book book, PatchBookRequest request);

    void delete(Long id);

    List<Book> priceLowestToHighest();

    List<Book> bookWithinPriceRange(int x);
}
