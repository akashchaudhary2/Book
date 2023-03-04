package com.akash.Book.interfaces;

import com.akash.Book.dto.BookRequest;
import com.akash.Book.model.Book;
import com.akash.Book.model.PatchBookRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface Controller {


    //////////
    //Create//
    ////////
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void create(@Valid @RequestBody BookRequest request);


    ////////
    //Read//
    ///////
    @GetMapping
    List<Book> getBook();
    @GetMapping("/book/{id}")
    Optional<Book> getBook(@PathVariable("id") String id);
    @GetMapping("/lowest-highest")
    List<Book> getBooksPriceLowestToHighest();


    //////////
    //update//
    /////////

    @PatchMapping("/book/{Id}")
    @ResponseStatus(HttpStatus.OK)
    void update(@PathVariable("Id") String Id, @RequestBody PatchBookRequest request);


    ///////////
    //Delete//
    /////////

}
