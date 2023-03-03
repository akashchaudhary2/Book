package com.akash.Book.classes;

import com.akash.Book.constants.AppConstants;
import com.akash.Book.model.Book;
import com.akash.Book.model.PatchBookRequest;
import com.akash.Book.repository.BookRepo;
import com.akash.Book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class BookServiceClass implements BookService {
    @Autowired
    private BookRepo bookRepo;

    @Override
    public void create(Book book) {
        bookRepo.save(book);
    }

    @Override
    public List<Book> getBooks() {
        return bookRepo.findAll();
    }

    @Override
    public Optional<Book> getBook(String id) {
        return bookRepo.findById(id);
    }

    @Override
    public void update(Book book, PatchBookRequest request) {
        validationForPatch(request);
        updateBook(book, request);
        bookRepo.save(book);
    }

    @Override
    public void delete(String id) {
        bookRepo.deleteById(id);
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
}
