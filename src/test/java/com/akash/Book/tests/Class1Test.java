package com.akash.Book.tests;

import com.akash.Book.model.Book;
import com.akash.Book.repository.BookRepo;
import com.akash.Book.tests.testService.TestService;
import com.akash.Book.tests.testService.TestServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class Class1Test {


    @Test
    public void testBooksLowestToHighest() {
        List<Book> books = Arrays.asList(
                new Book("akash", "java basic programing", 50.0),
                new Book("akash", "programing in java", 100.0),
                new Book("napoleon", "Think and grow rich", 150.0)
        );
        BookRepo bookRepo = Mockito.mock(BookRepo.class);
       when(bookRepo.findAll()).thenReturn(books);
        TestService service = new TestServiceImpl();
        assertEquals(service.priceLowestToHighest(bookRepo).get(0),
                books.get(0));

    }
}
