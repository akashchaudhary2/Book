package com.akash.BookUser.service;

import com.akash.BookUser.model.BookUser;

import java.util.List;
import java.util.Optional;

public interface BookUserService {

    BookUser saveUser(BookUser user);

    Optional<BookUser> getuser(Long userId);

    List<BookUser> getUsers();

    void associateBook(String userId, String bookId);

    List getBookOwned(String s);
}
