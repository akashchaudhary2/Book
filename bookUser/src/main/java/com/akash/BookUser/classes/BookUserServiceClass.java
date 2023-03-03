package com.akash.BookUser.classes;

import com.akash.BookUser.model.BookUser;
import com.akash.BookUser.repo.BookUserRepo;
import com.akash.BookUser.service.BookUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookUserServiceClass implements BookUserService {

    @Autowired
    BookUserRepo repo;

    @Override
    public BookUser saveUser(BookUser user) {
        repo.save(user);
        return user;
    }

    @Override
    public Optional<BookUser> getuser(Long userId) {
        return repo.findById(String.valueOf(userId));
    }
    @Override
    public List<BookUser> getUsers(){return repo.findAll();}

    @Override
    public void associateBook(String userId, String bookId) {

        var user = Optional.ofNullable(userId)
                .map(repo::findById)
                .orElseThrow();
        if (user.get().getBookOwned() == null){
            user.get().setBookOwned(bookId);
            repo.save(user.get());
        }
        if (user.get().getBookOwned() != null){
            String s= user.get().getBookOwned();
            s=s+" ";
            s=s+bookId;
            user.get().setBookOwned(s);
            repo.save(user.get());
        }


    }
    @Override
    public List getBookOwned(String userId){
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
            if (i==s1.length()-1){
                list.add(j, s);
            }
        }
        return list;
    }
}
