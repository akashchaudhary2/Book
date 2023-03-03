package com.akash.Book.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PatchBookRequest {
    @JsonProperty("author_name")
    private String authorName;
    @JsonProperty("book_tittle")
    private String bookTittle;
    private Double price;
    private String authorEmail;

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
