package com.akash.BookInventory.model;

import com.akash.BookInventory.dto.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "inventory")
public class Inventory {
    @Transient
    public static final String SEQUENCE_NAME = "user_sequence";
    @Id
    @JsonProperty("inventory_id")
    private String inventoryId;

    @JsonProperty("book_tittle")
    private String bookTittle;

    private long stock;
    private Status status;
}
