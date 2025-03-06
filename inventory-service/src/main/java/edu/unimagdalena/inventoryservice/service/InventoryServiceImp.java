package edu.unimagdalena.inventoryservice.service;

import edu.unimagdalena.inventoryservice.entity.Inventory;
import edu.unimagdalena.inventoryservice.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class InventoryServiceImp implements InventoryService {

    private InventoryRepository inventoryRepository;

    public InventoryServiceImp(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public Inventory findById(UUID id) {
        return inventoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Inventory> findAll() {
        return inventoryRepository.findAll();
    }

    @Override
    public Inventory save(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public void deleteById(UUID id) {
        inventoryRepository.deleteById(id);
    }

    @Override
    public Optional<Inventory> update(UUID id, Inventory inventory) {
        return inventoryRepository.findById(id).map(
                inventoryInBD->{
                    inventoryInBD.setProductId(inventory.getProductId());
                    inventoryInBD.setQuantity(inventory.getQuantity());
                    return inventoryRepository.save(inventoryInBD);
                }
        );
    }
}
