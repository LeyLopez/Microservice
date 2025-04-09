package edu.unimagdalena.productservices.service;

import edu.unimagdalena.productservices.entity.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {
    List<Product> findAll();

    Optional<Product> findById(UUID id);

    Product save(Product product);

    void deleteById(UUID id);

    Optional<Product> updateById(UUID id, Product product);
}
