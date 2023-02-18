package com.akash.Book.service;

import com.akash.Book.model.Book;
import com.akash.Book.repository.BookRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class Class1 implements BookService {
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
    public Optional<Book> cheapestBook() {
        return bookRepo.findAll()
                .stream()
                .min((x,y)->x.getPrice().compareTo(y.getPrice()));

    }
}
