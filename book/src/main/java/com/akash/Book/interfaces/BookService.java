package com.akash.Book.interfaces;

import com.akash.Book.dto.BookRequest;
import com.akash.Book.dto.BookResponse;
import com.akash.Book.model.Book;
import com.akash.Book.model.PatchBookRequest;

import java.util.List;
import java.util.Optional;

public interface BookService {
    //////////
    //Create//
    ////////
    void create(BookRequest request);


    ////////
    //Read//
    ///////
    List<Book> getBooks();
    List<Book> priceLowestToHighest();
    List<Book> bookWithinPriceRange(int x);
    Optional<Book> getBook(String id);


    //////////
    //update//
    /////////
    void update(Book book, PatchBookRequest request);
   BookResponse BookInventoryMap(String bookId, String inventoryId);

    ///////////
    //Delete//
    /////////
    void delete(String id);


}
