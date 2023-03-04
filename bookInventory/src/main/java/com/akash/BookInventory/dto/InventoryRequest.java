package com.akash.BookInventory.dto;

import com.akash.BookInventory.enums.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryRequest {
    @JsonProperty("book_tittle")
    private String bookTittle;
    private long stock;
}
