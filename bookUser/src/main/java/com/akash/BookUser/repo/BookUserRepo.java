package com.akash.BookUser.repo;

import com.akash.BookUser.model.BookUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookUserRepo extends MongoRepository<BookUser,String> {
}
