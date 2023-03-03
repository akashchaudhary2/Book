package com.akash.BookUser;

import com.akash.BookUser.classes.SequenceGeneratorService;
import com.akash.BookUser.controller.Controller;
import com.akash.BookUser.model.BookUser;
import com.akash.BookUser.service.BookUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.akash.BookUser.model.BookUser.SEQUENCE_NAME;

@SpringBootApplication
@RestController
@RequestMapping("users")
public class BookUserApplication implements Controller {
    @Autowired
    BookUserService service;
    @Autowired
    private SequenceGeneratorService generatorService;

    public static void main(String[] args) {
        SpringApplication.run(BookUserApplication.class, args);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public BookUser createUser(@RequestBody BookUser user) {
        user.setUserId(String.valueOf(generatorService.getSequenceNumber(SEQUENCE_NAME)));
        return service.saveUser(user);
    }

    @GetMapping()
    @Override
    public List<BookUser> getUsers() {
        return service.getUsers();
    }

    @GetMapping("/user/{id}")
    @Override
    public BookUser getUser(@PathVariable("id") String userId) {
        Optional<Optional<BookUser>> user = Optional.ofNullable(userId)
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
