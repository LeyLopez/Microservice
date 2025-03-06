package edu.unimagdalena.inventoryservice.service;

import edu.unimagdalena.inventoryservice.entity.Inventory;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface InventoryService {

    Inventory findById(UUID id);

    List<Inventory> findAll();

    Inventory save(Inventory inventory);

    void deleteById(UUID id);

    Optional<Inventory> update(UUID id, Inventory inventory);
}
