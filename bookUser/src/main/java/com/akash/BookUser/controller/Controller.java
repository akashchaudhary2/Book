package com.akash.BookUser.controller;

import com.akash.BookUser.model.BookUser;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface Controller {
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    BookUser createUser(@RequestBody BookUser user);

    @GetMapping()
    List<BookUser> getUsers();

    @GetMapping("/user/{id}")
    BookUser getUser(@PathVariable("id") String userId);

    @PostMapping("/user/{userId}/book/{bookId}")
    @ResponseStatus(HttpStatus.CREATED)
    void associateBook(@PathVariable("userId") String userId,
                       @PathVariable("bookId") String bookId);


    @PostMapping("/user/{userId}")
    List getBookOwned(@PathVariable("userId") String userId);
}
