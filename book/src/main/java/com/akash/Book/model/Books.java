package com.akash.Book.model;


import java.util.Arrays;
import java.util.List;

public class Books {
    List<Book> books = Arrays.asList(
            new Book("1", "akash", "akash@gmail.com", "programing in java", 100.0, "1"),
            new Book("2", "akash", "akash@gmail.com", "java basic programing", 50.0, "2"),
            new Book("3", "napoleon", "napolean@gmail.com", "Think and grow rich", 150.0, "3")
    );
}
