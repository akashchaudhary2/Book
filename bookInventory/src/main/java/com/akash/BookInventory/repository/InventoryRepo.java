package com.akash.BookInventory.repository;

import com.akash.BookInventory.model.Inventory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepo extends CrudRepository<Inventory,String> {
}
