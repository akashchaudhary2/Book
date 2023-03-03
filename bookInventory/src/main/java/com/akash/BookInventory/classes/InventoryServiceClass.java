package com.akash.BookInventory.classes;

import com.akash.BookInventory.model.Inventory;
import com.akash.BookInventory.enums.Status;
import com.akash.BookInventory.repository.InventoryRepo;
import com.akash.BookInventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryServiceClass implements InventoryService {
    @Autowired
    private InventoryRepo repo;

    @Override
    public List<Inventory> getAll() {
        return (List<Inventory>) repo.findAll();
    }

    @Override
    public void save(Inventory inventory) {
        repo.save(inventory);
        if (inventory.getStock() > 0)
            inventory.setStatus(Status.Available);
             repo.save(inventory);
    }

    @Override
    public Status inventoryCheck(String id) {
        var inventory = Optional.ofNullable(id)
                .map(x -> Long.valueOf(id))
                .map(repo::findById)
                .orElseThrow();
        if(inventory.get().getStatus()==Status.Available)
            return Status.Available;
        else
            return Status.OutOfStock;
    }
}
