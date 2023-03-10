package com.akash.Book.dto;

import com.akash.Book.constants.AppConstants;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {
    @JsonProperty("author_name")
    @NotBlank(message = "author name can't be blank")
    @NotEmpty(message = "author name can't be empty")
    private String authorName;
    @JsonProperty("author_email")
    @Pattern(regexp = AppConstants.EMAIL_REGEXPR, message = "Email must be valid")
    @Email(message = "email must be valid")
    private String authorEmail;
    @JsonProperty("book_tittle")
    @NotNull()
    @NotBlank(message = "book tittle  can't be blank")
    @NotEmpty(message = "book tittle can't be empty")
    private String bookTittle;
    @JsonProperty("price")
    private Double price;
}
