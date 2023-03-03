package com.akash.Book.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Document(collection = "book")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Book {
    @Transient
    public static final String SEQUENCE_NAME = "user_sequence";
    @Id
    private String bookId;
    private String authorName;
    private String authorEmail;
    private String bookTittle;
    private Double price;
}
