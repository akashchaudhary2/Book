package com.akash.BookUser.service;

import com.akash.BookUser.dto.UserRequest;
import com.akash.BookUser.dto.UserResponse;
import com.akash.BookUser.model.User;

import java.util.List;
import java.util.Optional;

public interface BookUserService {

    UserRequest saveUser(UserRequest request);

    Optional<User> getuser(Long userId);

    List<UserResponse> getUsers();

    void associateBook(String userId, String bookId);

    List getBookOwned(String s);
}
