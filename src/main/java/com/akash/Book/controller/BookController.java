package com.akash.Book.controller;

import com.akash.Book.model.Book;
import com.akash.Book.service.BookS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookS bookS;

    @GetMapping("/akash")
    public String hello() {
        return "Akash";
    }

    @GetMapping("/")
    public List<Book> getBook() {
        return bookS.getBooks();
    }

    @GetMapping("/lowest-highest")
    public List<Book> getBooksPriceLowestToHighest() {
        return bookS.priceLowestToHighest();
    }


    @PostMapping("/")
    public void create(@RequestBody Book book) {
        bookS.create(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        Long a = Long.valueOf(id);
        bookS.delete(a);
    }
}
