package com.akash.Book.controller;

import com.akash.Book.model.Book;
import com.akash.Book.model.PatchBookRequest;
import com.akash.Book.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
public class Controller{
    @Autowired
    private BookService bookService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody Book book) {
        bookService.create(book);
    }

    @GetMapping("/")
    public List<Book> getBook() {
        return bookService.getBooks();
    }

    @GetMapping("/book/{id}")
    public Optional<Book> getBook(@PathVariable("id") String id) {
        return Optional.ofNullable(id)
                .map(x -> Long.valueOf(id))
                .map(bookService::getBook)
                .orElseThrow();
    }
    @PatchMapping("/{Id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("Id") String Id,@RequestBody PatchBookRequest request){
       Optional<Book> book = Optional.ofNullable(Id)
                .map(i->Long.valueOf(Id))
                .map(bookService::getBook)
                .orElseThrow();
       bookService.update(book.get(),request);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        Optional<Book> book = Optional.ofNullable(id)
                .map(x -> Long.valueOf(id))
                .map(bookService::getBook)
                .orElseThrow();
        book.map(x->x.getId()).ifPresent(bookService::delete);
    }


    @GetMapping("/lowest-highest")
    public List<Book> getBooksPriceLowestToHighest() {
        return bookService.priceLowestToHighest();
    }


}
