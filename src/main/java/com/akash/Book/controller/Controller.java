package com.akash.Book.controller;

import com.akash.Book.exceptions.BaseExceptionHandler;
import com.akash.Book.model.Book;
import com.akash.Book.model.PatchBookRequest;
import com.akash.Book.service.BookS;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller extends BaseExceptionHandler {
    @Autowired
    private BookS bookS;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody Book book) {
        bookS.create(book);
    }

    @GetMapping("/")
    public List<Book> getBook() {
        return bookS.getBooks();
    }

    @GetMapping("/book/{id}")
    public Optional<Book> getBook(@PathVariable("id") String id) {
        return Optional.ofNullable(id)
                .map(x -> Long.valueOf(id))
                .map(bookS::getBook)
                .orElseThrow();
    }
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") String id,@RequestBody PatchBookRequest request){
        var user = Optional.ofNullable(id)
                .map(i->Long.valueOf(i))
                .map(bookS::getBook)
                .orElseThrow();
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        var book = Optional.ofNullable(id)
                .map(x -> Long.valueOf(id))
                .map(bookS::getBook)
                .orElseThrow();
        bookS.delete(Long.valueOf(id));
    }


    @GetMapping("/lowest-highest")
    public List<Book> getBooksPriceLowestToHighest() {
        return bookS.priceLowestToHighest();
    }


}
