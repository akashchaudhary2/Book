package com.akash.BookInventory.classes;

import com.akash.BookInventory.dto.InventoryRequest;
import com.akash.BookInventory.dto.InventoryResponse;
import com.akash.BookInventory.dto.InventoryStockResponse;
import com.akash.BookInventory.model.Inventory;
import com.akash.BookInventory.dto.Status;
import com.akash.BookInventory.repository.InventoryRepo;
import com.akash.BookInventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.akash.BookInventory.model.Inventory.SEQUENCE_NAME;

@Service
public class InventoryServiceClass implements InventoryService {
    @Autowired
    private InventoryRepo repo;
    @Autowired
    private SequenceGeneratorService generatorService;

    @Override
    public List<InventoryResponse> getAll() {
        List<Inventory> list = (List<Inventory>) repo.findAll();
        return list.stream().map(this::inventoryResponseMap).toList();
    }

    private InventoryResponse inventoryResponseMap(Inventory inventory) {
        InventoryResponse response = InventoryResponse.builder()
                .inventoryId(inventory.getInventoryId())
                .bookTittle(inventory.getBookTittle())
                .stock(inventory.getStock())
                .status(inventory.getStatus())
                .build();
        return response;
    }

    @Override
    public InventoryRequest save(InventoryRequest request) {
        Inventory inventory = Inventory.builder()
                .inventoryId(String.valueOf(generatorService.getSequenceNumber(SEQUENCE_NAME)))
                .bookTittle(request.getBookTittle())
                .stock(request.getStock())
                .build();
        if (request.getStock() > 0)
            inventory.setStatus(Status.Available);
        repo.save(inventory);
        return request;
    }

    @Override
    public InventoryStockResponse inventoryCheck(String id) {
        var inventory = Optional.ofNullable(id)
                .map(repo::findById)
                .orElseThrow();
        InventoryStockResponse response = InventoryStockResponse.builder().build();
        if (inventory.get().getStatus() == Status.Available) {
            response.setStatus(Status.Available);
        } else {
            response.setStatus(Status.OutOfStock);
        }
        return response;
    }
}
