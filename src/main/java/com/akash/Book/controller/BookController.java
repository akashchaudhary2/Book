package com.akash.Book.controller;

import com.akash.Book.model.Book;
import com.akash.Book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping("/akash")
    public String hello(){
        return "Akash";
    }
    @GetMapping("/hello")
    public List<Book> getBook(){
        return bookService.getBooks();
    }


}
