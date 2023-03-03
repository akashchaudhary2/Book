package com.akash.BookUser.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "book")
public class BookUser {
    @Transient
    public static final String SEQUENCE_NAME = "user_sequence";
    @Id
    private String userId;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("book_owned")
    private String bookOwned;

    public BookUser(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
