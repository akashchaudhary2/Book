package com.akash.Book.interfaces;

import com.akash.Book.dto.BookRequest;
import com.akash.Book.dto.BookResponse;
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
    BookResponse create(@Valid @RequestBody BookRequest request);


    ////////
    //Read//
    ///////
    @GetMapping
    List<Book> getBook();
    @GetMapping("/book/{bookId}")
    Optional<Book> getBook(@PathVariable("bookId") String bookId);
    @GetMapping("/lowest-highest")
    List<Book> getBooksPriceLowestToHighest();


    //////////
    //update//
    /////////

    @PatchMapping("/book/{Id}")
    @ResponseStatus(HttpStatus.OK)
    void update(@PathVariable("Id") String Id, @RequestBody PatchBookRequest request);

    @PatchMapping("/book/{bookId}/inventory/{inventoryId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    Optional<Book> inventoryAssociation(@PathVariable("bookId") String bookId, @PathVariable("inventoryId") String inventoryId);


    ///////////
    //Delete//
    /////////

}
