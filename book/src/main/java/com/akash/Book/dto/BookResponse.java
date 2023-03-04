package com.akash.Book.dto;

import com.akash.Book.constants.AppConstants;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {
    @JsonProperty("book_id")
    private String bookId;
    @JsonProperty("author_name")
    private String authorName;
    @JsonProperty("author_email")
    private String authorEmail;
    @JsonProperty("book_tittle")
    private String bookTittle;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("inventory_id")
    private String inventoryId;
}
