package com.akash.Book;

import com.akash.Book.model.Book;
import com.akash.Book.repository.BookRepo;
import com.akash.Book.service.BookService;
import com.akash.Book.service.Class1;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class BookApplicationTests {
    @MockBean
    BookRepo bookRepo;
    @Autowired
    BookService service;
    @Test
    public void testBooksLowestToHighest() {
        List<Book> books = Arrays.asList(new Book("akash", "java basic programing", 50.0), new Book("akash", "programing in java", 100.0), new Book("napoleon", "Think and grow rich", 150.0));
        when(bookRepo.findAll()).thenReturn(books);
        assertEquals(service.priceLowestToHighest().get(0), books.get(0));
        assertEquals(service.priceLowestToHighest().get(1), books.get(1));
        assertEquals(service.priceLowestToHighest().get(2), books.get(2));
    }

}
