package com.akash.Book.interfaces;

import com.akash.Book.dto.BookRequest;
import com.akash.Book.model.Book;
import com.akash.Book.model.PatchBookRequest;

import java.util.List;
import java.util.Optional;

public interface BookService {

    void create(BookRequest request);

    List<Book> getBooks();

    Optional<Book> getBook(String id);

    void update(Book book, PatchBookRequest request);

    void delete(String id);

    List<Book> priceLowestToHighest();

    List<Book> bookWithinPriceRange(int x);
}
