package com.akash.Book.tests.testService;

import com.akash.Book.model.Book;
import com.akash.Book.repository.BookRepo;
import com.akash.Book.tests.testService.TestService;

import java.util.List;
import java.util.stream.Collectors;

public class TestServiceImpl implements TestService {
    @Override
    public List<Book> priceLowestToHighest(BookRepo bookRepo) {
        return bookRepo.findAll()
                .stream()
                .sorted((x, y) -> x.getPrice().compareTo(y.getPrice()))
                .collect(Collectors.toList());
    }
}