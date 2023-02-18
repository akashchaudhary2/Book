package com.akash.Book.controller;

import com.akash.Book.model.Book;
import com.akash.Book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/akash")
    public String hello() {
        return "Akash";
    }

    @GetMapping("/")
    public List<Book> getBook() {
        return bookService.getBooks();
    }

    @PostMapping("/")
    public void create(@RequestBody Book book) {
        bookService.create(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        Long a =Long.valueOf(id);
        bookService.delete(a);
    }
}
