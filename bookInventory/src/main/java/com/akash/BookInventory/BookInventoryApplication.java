package com.akash.BookInventory;

import com.akash.BookInventory.classes.SequenceGeneratorService;
import com.akash.BookInventory.enums.Status;
import com.akash.BookInventory.model.Inventory;
import com.akash.BookInventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.akash.BookInventory.model.Inventory.SEQUENCE_NAME;

@SpringBootApplication
@RestController
@RequestMapping("inventory")
public class BookInventoryApplication {
    @Autowired
    private InventoryService service;
    @Autowired
    private SequenceGeneratorService generatorService;

    public static void main(String[] args) {
        SpringApplication.run(BookInventoryApplication.class, args);
    }


    @PostMapping
    public void create(@RequestBody Inventory inventory) {
        inventory.setInventoryId(String.valueOf(generatorService.getSequenceNumber(SEQUENCE_NAME)));
        service.save(inventory);
    }

    @GetMapping("/stock/{inventoryId}")
    public Status inventoryCheck(@PathVariable("inventoryId") String inventoryId) {
        return service.inventoryCheck(inventoryId);
    }

    @GetMapping
    public List<Inventory> getAll() {
        return service.getAll();
    }
}
