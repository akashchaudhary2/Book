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
}
