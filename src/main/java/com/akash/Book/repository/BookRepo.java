package com.akash.Book.repository;

import com.akash.Book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
    Book findByBookId(Long id);
    void deleteByBookId(Long id);
}
