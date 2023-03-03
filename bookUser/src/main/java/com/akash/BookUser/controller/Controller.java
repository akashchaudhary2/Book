package com.akash.BookUser.controller;

import com.akash.BookUser.dto.UserRequest;
import com.akash.BookUser.dto.UserResponse;
import com.akash.BookUser.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface Controller {

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    UserRequest createUser(@RequestBody UserRequest request);

    @GetMapping()
    List<UserResponse> getUsers();

    @GetMapping("/user/{id}")
    User getUser(@PathVariable("id") String userId);

    @PostMapping("/user/{userId}/book/{bookId}")
    @ResponseStatus(HttpStatus.CREATED)
    void associateBook(@PathVariable("userId") String userId,
                       @PathVariable("bookId") String bookId);


    @PostMapping("/user/{userId}")
    List getBookOwned(@PathVariable("userId") String userId);
}
