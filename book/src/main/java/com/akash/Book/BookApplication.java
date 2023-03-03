package com.akash.Book;

import com.akash.Book.classes.SequenceGeneratorService;
import com.akash.Book.dto.BookRequest;
import com.akash.Book.model.Book;
import com.akash.Book.model.PatchBookRequest;
import com.akash.Book.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.akash.Book.model.Book.SEQUENCE_NAME;

@SpringBootApplication
@RestController
@RequestMapping("books")
public class BookApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookApplication.class, args);
    }

    @Autowired
    private BookService bookService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody BookRequest request) {
        bookService.create(request);
    }

    @GetMapping
    public List<Book> getBook() {
        return bookService.getBooks();
    }

    @GetMapping("/book/{id}")
    public Optional<Book> getBook(@PathVariable("id") String id) {
        return Optional.ofNullable(id)
                .map(bookService::getBook)
                .orElseThrow();
    }

    @PatchMapping("/book/{Id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("Id") String Id, @RequestBody PatchBookRequest request) {
        Optional<Book> book = Optional.ofNullable(Id)
                .map(bookService::getBook)
                .orElseThrow();
        bookService.update(book.get(), request);
    }

//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable("id") String id) {
//        Optional<Book> book = Optional.ofNullable(id)
//                .map(bookService::getBook)
//                .orElseThrow();
//        book.map(x -> x.getId()).ifPresent(bookService::delete);
//    }


    @GetMapping("/lowest-highest")
    public List<Book> getBooksPriceLowestToHighest() {
        return bookService.priceLowestToHighest();
    }
}
