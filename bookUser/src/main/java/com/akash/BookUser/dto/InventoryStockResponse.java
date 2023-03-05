package com.akash.BookUser.dto;

import com.akash.BookUser.dto.Status;
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
