package edu.unimagdalena.inventoryservice.controller;

import edu.unimagdalena.inventoryservice.entity.Inventory;
import edu.unimagdalena.inventoryservice.service.InventoryService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping
    public Flux<List<Inventory>> getInventories() {
        return Flux.just(inventoryService.findAll());
    }

    @GetMapping("{id}")
    public Mono<Inventory> getInventoryById(@PathVariable ("id") UUID id) {
        return Mono.justOrEmpty(inventoryService.findById(id));
    }

    @PostMapping
    public Mono<Inventory> createInventory(@RequestBody Inventory inventory) {
        return Mono.just(inventoryService.save(inventory));
    }

    @PutMapping("{id}")
    public Mono<Inventory> updateInventory(@PathVariable ("id") UUID id, @RequestBody Inventory inventory) {
        return Mono.justOrEmpty(inventoryService.update(id, inventory));
    }

    @DeleteMapping("{id}")
    public Mono<Void> deleteInventory(@PathVariable ("id") UUID id) {
        inventoryService.deleteById(id);
        return Mono.empty();
    }


}
