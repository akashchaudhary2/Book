package com.akash.BookUser;
import com.akash.BookUser.controller.Controller;
import com.akash.BookUser.dto.UserRequest;
import com.akash.BookUser.dto.UserResponse;
import com.akash.BookUser.model.User;
import com.akash.BookUser.interfae.BookUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("users")
public class BookUserApplication implements Controller {
    @Autowired
    BookUserService service;

    public static void main(String[] args) {
        SpringApplication.run(BookUserApplication.class, args);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public UserRequest createUser(@RequestBody UserRequest request) {
        service.saveUser(request);
        return request;
    }

    @GetMapping()
    @Override
    public List<UserResponse> getUsers() {
        return service.getUsers();
    }

    @GetMapping("/user/{id}")
    @Override
    public User getUser(@PathVariable("id") String userId) {
        Optional<Optional<User>> user = Optional.ofNullable(userId)
                .map(x -> Long.valueOf(userId))
                .map(service::getuser);
        return user.get().get();
    }

    @PostMapping("/user/{userId}/book/{bookId}")
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public void associateBook(@PathVariable("userId") String userId,
                              @PathVariable("bookId") String bookId) {
        service.associateBook(userId, bookId);
    }

    @GetMapping("/books/{userId}")
    @Override
    public List getBookOwned(@PathVariable("userId") String userId) {
        return service.getBookOwned(userId);
    }
}
