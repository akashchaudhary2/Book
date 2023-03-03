package com.akash.Book;

import com.akash.Book.model.Book;
import com.akash.Book.repository.BookRepo;
import com.akash.Book.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class BookApplicationTests {
    @MockBean
    BookRepo bookRepo;
    @Autowired
    BookService service;

    @Test
    public void testBooksLowestToHighest() {
        List<Book> books = Arrays.asList(new Book("akash", "akash@gmail.com", "java basic programing", 50.0), new Book("akash", "akash@gmail.com", "programing in java", 100.0), new Book("napoleon", "napolean@gmail.com", "Think and grow rich", 150.0));
        when(bookRepo.findAll()).thenReturn(books);
        assertEquals(service.priceLowestToHighest().get(0), books.get(0));
        assertEquals(service.priceLowestToHighest().get(1), books.get(1));
        assertEquals(service.priceLowestToHighest().get(2), books.get(2));
    }

    @Test
    public void testBookWithinPriceRange() {
        List<Book> books = Arrays.asList(new Book("akash", "akash@gmail.com", "java basic programing", 50.0), new Book("akash", "akash@gmail.com", "programing in java", 100.0));
        when(bookRepo.findAll()).thenReturn(books);
        Integer size = service.bookWithinPriceRange(100).size();
        assertFalse(size.equals(1));
        assertTrue(size.equals(2));
        assertFalse(size.equals(3));
        assertEquals(service.bookWithinPriceRange(100).get(0),
                books.get(0));
    }

}
