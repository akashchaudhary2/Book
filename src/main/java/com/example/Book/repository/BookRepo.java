package com.example.Book.repository;

import com.example.Book.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Books,Long> {
}
