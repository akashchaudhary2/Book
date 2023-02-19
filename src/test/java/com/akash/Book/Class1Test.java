package com.akash.Book;

import com.akash.Book.model.Book;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Class1Test implements BookServiceTest {
    @Override
    @Test
    public void testBooksLowestToHighest() {
        List<Book> books = Arrays.asList(
                new Book("akash", "programing in java", 100.0),
                new Book("akash", "programing in java", 100.0),
                new Book("akash","java basic programing",50.0)
        );
    }
}
