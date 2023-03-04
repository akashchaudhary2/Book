package com.akash.BookInventory.dto;

import com.akash.BookInventory.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventoryStockResponse {
    private Status status;
}
