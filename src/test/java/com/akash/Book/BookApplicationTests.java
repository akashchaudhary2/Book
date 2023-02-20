package com.akash.Book;

import com.akash.Book.model.Book;
import com.akash.Book.repository.BookRepo;
import com.akash.Book.testService.TestService;
import com.akash.Book.testService.TestServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class BookApplicationTests {

    @Test
    public void testBooksLowestToHighest() {
        List<Book> books = Arrays.asList(new Book("akash", "java basic programing", 50.0), new Book("akash", "programing in java", 100.0), new Book("napoleon", "Think and grow rich", 150.0));
        BookRepo bookRepo = Mockito.mock(BookRepo.class);
        when(bookRepo.findAll()).thenReturn(books);
        TestService service = new TestServiceImpl();
        assertEquals(service.priceLowestToHighest(bookRepo).get(0), books.get(0));
        assertEquals(service.priceLowestToHighest(bookRepo).get(1), books.get(1));
        assertEquals(service.priceLowestToHighest(bookRepo).get(2), books.get(2));
    }

}
