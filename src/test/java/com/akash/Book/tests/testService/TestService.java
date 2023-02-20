package com.akash.Book.tests.testService;

import com.akash.Book.model.Book;
import com.akash.Book.repository.BookRepo;

import java.util.List;

public interface TestService {
    List<Book> priceLowestToHighest(BookRepo bookRepo);
}
