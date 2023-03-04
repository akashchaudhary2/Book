package com.akash.BookInventory;

import com.akash.BookInventory.dto.InventoryRequest;
import com.akash.BookInventory.dto.InventoryResponse;
import com.akash.BookInventory.dto.InventoryStockResponse;
import com.akash.BookInventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("inventory")
public class BookInventoryApplication {
    @Autowired
    private InventoryService service;

    public static void main(String[] args) {
        SpringApplication.run(BookInventoryApplication.class, args);
    }


    @PostMapping
    public InventoryRequest create(@RequestBody InventoryRequest request) {
        return service.save(request);
    }

    @GetMapping("/stock/{inventoryId}")
    public InventoryStockResponse inventoryCheck(@PathVariable("inventoryId") String inventoryId) {
        return service.inventoryCheck(inventoryId);
    }

    @GetMapping
    public List<InventoryResponse> getAll() {
        return service.getAll();
    }
}
