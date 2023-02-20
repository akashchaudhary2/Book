package com.akash.Book.service;

import com.akash.Book.model.Book;
import com.akash.Book.repository.BookRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookService implements BookS {
    @Autowired
    private BookRepo bookRepo;

    @Override
    public List<Book> getBooks() {
        return bookRepo.findAll();
    }

    @Override
    public void create(Book book) {
        bookRepo.save(book);
    }

    @Override
    public void delete(Long id) {
        bookRepo.deleteById(id);
    }

    @Override
    public List<Book> priceLowestToHighest() {
        return bookRepo.findAll()
                .stream()
                .sorted((x, y) -> x.getPrice().compareTo(y.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> bookWithinPriceRange(int x) {
        return bookRepo.findAll()
                .stream()
                .filter(b -> b.getPrice() <= x)
                .collect(Collectors.toList());
    }
}
