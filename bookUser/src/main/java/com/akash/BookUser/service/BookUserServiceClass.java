package com.akash.BookUser.service;

import com.akash.BookUser.dto.InventoryStockResponse;
import com.akash.BookUser.dto.Status;
import com.akash.BookUser.dto.UserRequest;
import com.akash.BookUser.dto.UserResponse;
import com.akash.BookUser.model.User;
import com.akash.BookUser.interfae.BookUserRepo;
import com.akash.BookUser.interfae.BookUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.akash.BookUser.model.User.SEQUENCE_NAME;

@Service
@RequiredArgsConstructor
public class BookUserServiceClass implements BookUserService {

    @Autowired
    BookUserRepo repo;
    private SequenceGeneratorService generatorService;
    private final WebClient webClient;


    @Override
    public UserRequest saveUser(UserRequest request) {
        User user = User.builder()
                .userId(String.valueOf(generatorService.getSequenceNumber(SEQUENCE_NAME)))
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .build();
        repo.save(user);
        return request;
    }

    @Override
    public Optional<User> getuser(Long userId) {
        return repo.findById(String.valueOf(userId));
    }

    @Override
    public List<UserResponse> getUsers() {
        List<User> list = repo.findAll();
        return list.stream().map(this::mapToUserResponse).toList();
    }

    private UserResponse mapToUserResponse(User user) {
        return UserResponse.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .bookOwned(user.getBookOwned())
                .build();
    }

    @Override
    public void associateBook(String userId, String bookId) {
        InventoryStockResponse response
                = webClient.get()
                .uri("http://localhost:8082/inventory",
                uriBuilder -> uriBuilder.queryParam("inventoryId",2).build())
                .retrieve()
                .bodyToMono(InventoryStockResponse.class)
                .block();
        var user = Optional.ofNullable(userId)
                .map(repo::findById)
                .orElseThrow();
        if (response.getStatus().equals(Status.Available)){
            if (user.get().getBookOwned() == null) {
                user.get().setBookOwned(bookId);
                repo.save(user.get());
            }
            if (user.get().getBookOwned() != null) {
                String s = user.get().getBookOwned();
                s = s + " ";
                s = s + bookId;
                user.get().setBookOwned(s);
                repo.save(user.get());
            }
        }else {
            return;
        }
    }

    @Override
    public List getBookOwned(String userId) {
        var user = Optional.ofNullable(userId)
                .map(repo::findById)
                .orElseThrow();
        String s1 = user.get().getBookOwned();
        s1.trim();
        List list = new ArrayList();
        int j = 0;
        String s = "";
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != ' ') {
                s = s + s1.charAt(i);
            } else {
                list.add(j, s);
                j++;
                s = "";
            }
            if (i == s1.length() - 1) {
                list.add(j, s);
            }
        }
        return list;
    }
}
