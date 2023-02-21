package com.akash.Book.model;

import com.akash.Book.constants.AppConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long Id;
    @Column(length = 35)
    @JsonProperty("author_name")
    @NotBlank(message = "author name can't be blank")
    @NotEmpty(message = "author name can't be empty")
    private String authorName;
    @Column(length=30)
    @Pattern(regexp = AppConstants.EMAIL_REGEXPR, message = "Email must be valid")
    @JsonProperty("author_email")
    @JsonIgnore
    @Email(message = "email must be valid")
    private String authorEmail;
    @NotNull(message = "book tittle  can't be null")
    @NotBlank(message = "book tittle  can't be blank")
    @NotEmpty(message = "book tittle can't be empty")
    @Column(length = 35)
    @JsonProperty("book_tittle")
    private String bookTittle;
    @Column(length = 35)
    private Double price;


    public Book() {
    }

    public Book(String authorName, String authorEmail, String bookTittle, Double price) {
        this.authorName = authorName;
        this.authorEmail = authorEmail;
        this.bookTittle = bookTittle;
        this.price = price;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public String getBookTittle() {
        return bookTittle;
    }

    public void setBookTittle(String bookTittle) {
        this.bookTittle = bookTittle;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


}
