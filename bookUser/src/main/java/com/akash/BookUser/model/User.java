package com.akash.BookUser.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "book")
public class User {
    @Transient
    public static final String SEQUENCE_NAME = "user_sequence";
    @Id
    private String userId;
    private String firstName;
    private String lastName;
    private String bookOwned;
}
