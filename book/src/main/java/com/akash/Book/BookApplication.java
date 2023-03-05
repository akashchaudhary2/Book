package com.akash.Book;

import com.akash.Book.dto.BookRequest;
import com.akash.Book.dto.BookResponse;
import com.akash.Book.interfaces.Controller;
import com.akash.Book.model.Book;
import com.akash.Book.model.PatchBookRequest;
import com.akash.Book.interfaces.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("books")
public class BookApplication implements Controller {

    public static void main(String[] args) {
        SpringApplication.run(BookApplication.class, args);
    }

    @Autowired
    private BookService bookService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public BookResponse create(@Valid @RequestBody BookRequest request) {
        return bookService.create(request);
    }

    @GetMapping
    @Override
    public List<Book> getBook() {
        return bookService.getBooks();
    }

    @GetMapping("/book/{bookId}")
    @Override
    public Optional<Book> getBook(@PathVariable("bookId") String bookId) {
        return Optional.ofNullable(bookId)
                .map(bookService::getBook)
                .orElseThrow();
    }

    @GetMapping("/lowest-highest")
    @Override
    public List<Book> getBooksPriceLowestToHighest() {
        return bookService.priceLowestToHighest();
    }

    @PatchMapping("/book/{Id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public void update(@PathVariable("Id") String Id, @RequestBody PatchBookRequest request) {
        Optional<Book> book = Optional.ofNullable(Id)
                .map(bookService::getBook)
                .orElseThrow();
//        bookService.update(book, request);
    }
    @PatchMapping("/book/{bookId}/inventory/{inventoryId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Override
    public Optional<Book> inventoryAssociation(@PathVariable("bookId") String bookId, @PathVariable("inventoryId") String inventoryId){
        return bookService.BookInventoryMap(bookId,inventoryId);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        Optional<Book> book = Optional.ofNullable(id)
                .map(bookService::getBook)
                .orElseThrow();
        if(book.isPresent()){
            bookService.delete(id);
        }

    }


}
