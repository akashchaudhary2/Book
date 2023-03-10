package com.akash.Book.service;

import com.akash.Book.constants.AppConstants;
import com.akash.Book.dto.BookRequest;
import com.akash.Book.dto.BookResponse;
import com.akash.Book.model.Book;
import com.akash.Book.model.PatchBookRequest;
import com.akash.Book.interfaces.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.akash.Book.model.Book.SEQUENCE_NAME;

@Service
public class BookService implements com.akash.Book.interfaces.BookService {
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private SequenceGeneratorService generatorService;

    public BookResponse bookResponseMapper(Book book) {
        BookResponse response = BookResponse.builder()
                .bookId(book.getBookId())
                .authorName(book.getAuthorName())
                .bookTittle(book.getBookTittle())
                .authorEmail("********")
                .price(book.getPrice())
                .inventoryId(book.getInventoryId())
                .build();
        return response;
    }

    @Override
    public BookResponse create(BookRequest request) {
        Book book = Book.builder()
                .bookId(String.valueOf(generatorService.getSequenceNumber(SEQUENCE_NAME)))
                .bookTittle(request.getBookTittle())
                .authorName(request.getAuthorName())
                .authorEmail(request.getAuthorEmail())
                .price(request.getPrice())
                .inventoryId("")
                .build();
        bookRepo.save(book);
        return bookResponseMapper(book);
    }

    @Override
    public List<Book> getBooks() {
        return bookRepo.findAll();
    }

    @Override
    public Optional<Book> getBook(String bookId) {
        Optional<Book> book = bookRepo.findById(bookId);
        return book;

    }

    @Override
    public List<Book> priceLowestToHighest() {
        return bookRepo.findAll()
                .stream()
                .sorted((x, y) -> x.getPrice().compareTo(y.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> bookWithinPriceRange(int x) {
        return priceLowestToHighest()
                .stream()
                .filter(b -> b.getPrice() <= x)
                .collect(Collectors.toList());
    }

    private void validationForPatch(PatchBookRequest request) {
        if (request.getAuthorName() != null && request.getAuthorName().isBlank())
            new IllegalArgumentException("name can't be blank");
        if (request.getAuthorEmail() != null && request.getAuthorEmail().isBlank())
            new IllegalArgumentException("email can't be blank");
        if (request.getBookTittle() != null && request.getBookTittle().isBlank())
            new IllegalArgumentException("book tittle can't be blank");
        if (request.getPrice() != null && String.valueOf(request.getPrice()).isBlank())
            new IllegalArgumentException("price can't be blank");
        if (request.getAuthorEmail() != null && !Pattern.matches(AppConstants.EMAIL_REGEXPR, request.getAuthorEmail()))
            new IllegalArgumentException("Email must be valid");
    }

    private void updateBook(Book book, PatchBookRequest request) {
        if (request.getAuthorName() != null)
            book.setAuthorName(request.getAuthorName());
        if (request.getAuthorEmail() != null)
            book.setAuthorName(request.getAuthorName());
        if (request.getBookTittle() != null)
            book.setBookTittle(request.getBookTittle());
        if (request.getPrice() != null)
            book.setPrice(request.getPrice());
    }

    @Override
    public void update(Book book, PatchBookRequest request) {
        validationForPatch(request);
        updateBook(book, request);
        bookRepo.save(book);
    }

    @Override
    public Optional<Book> BookInventoryMap(String bookId, String inventoryId) {
        Optional<Book> book1 = bookRepo.findById(bookId);
        book1.get().setInventoryId(inventoryId);
        bookRepo.save(book1.get());
        return book1;

    }


    @Override
    public void delete(String id) {
        bookRepo.deleteById(id);
    }

}
