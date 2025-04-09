package edu.unimagdalena.orderservice.service;

import edu.unimagdalena.orderservice.entity.Order;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderService {

    List<Order> findAll();

    Optional<Order> findById(UUID id);

    Order save(Order order);

    void delete(UUID id);

    Optional<Order> updateById(UUID id, Order order);
}
