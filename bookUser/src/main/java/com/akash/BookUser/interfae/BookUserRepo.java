package com.akash.BookUser.interfae;

import com.akash.BookUser.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookUserRepo extends MongoRepository<User,String> {
}
