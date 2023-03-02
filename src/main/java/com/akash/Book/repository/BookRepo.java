package com.akash.Book.repository;

import com.akash.Book.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepo extends MongoRepository<Book,String> {
}
