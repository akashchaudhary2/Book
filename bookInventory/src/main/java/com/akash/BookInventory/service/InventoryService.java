package com.akash.BookInventory.service;

import com.akash.BookInventory.model.Inventory;
import com.akash.BookInventory.enums.Status;

import java.util.List;

public interface InventoryService {

    List<Inventory> getAll();

    void save(Inventory inventory);

    Status inventoryCheck(String inventoryId);
}
