package com.example.Book.controller;

import com.example.Book.model.Book;
import com.example.Book.service.BooksService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class BookController {
    @Autowired
    private BooksService booksService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Book book) {
        booksService.create(book);
    }

   @GetMapping("/hello")
    public String hello(){
        return"Hello world";
   }

}
