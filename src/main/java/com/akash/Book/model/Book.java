package com.akash.Book.model;

import com.akash.Book.constants.AppConstants;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.*;
import lombok.Data;

import lombok.NoArgsConstructor;

import static com.akash.Book.model.Inventory.SEQUENCE_NAME;

import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Data
@Document(collection = "book")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Book {
    @org.springframework.data.annotation.Transient
    public static final String SEQUENCE_NAME = "user_sequence";
    private String bookId;

    @JsonProperty("author_name")
    @NotBlank(message = "author name can't be blank")
    @NotEmpty(message = "author name can't be empty")
    private String authorName;

    @Pattern(regexp = AppConstants.EMAIL_REGEXPR, message = "Email must be valid")
    @JsonProperty("author_email")
    @Email(message = "email must be valid")
    private String authorEmail;
    @NotNull()
    @NotBlank(message = "book tittle  can't be blank")
    @NotEmpty(message = "book tittle can't be empty")

    @JsonProperty("book_tittle")
    private String bookTittle;

    private Double price;

    public Book(String authorName, String authorEmail, String bookTittle, Double price) {
        this.authorName = authorName;
        this.authorEmail = authorEmail;
        this.bookTittle = bookTittle;
        this.price = price;
    }


}
