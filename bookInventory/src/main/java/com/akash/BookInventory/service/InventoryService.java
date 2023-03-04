package com.akash.BookInventory.service;

import com.akash.BookInventory.dto.InventoryRequest;
import com.akash.BookInventory.dto.InventoryResponse;
import com.akash.BookInventory.dto.InventoryStockResponse;

import java.util.List;

public interface InventoryService {

    List<InventoryResponse> getAll();

    InventoryRequest save(InventoryRequest request);

    InventoryStockResponse inventoryCheck(String inventoryId);
}
