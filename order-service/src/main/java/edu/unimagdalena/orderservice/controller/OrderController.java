package edu.unimagdalena.orderservice.controller;

import edu.unimagdalena.orderservice.entity.Order;
import edu.unimagdalena.orderservice.service.OrderService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public Flux<Order> getAllOrders() {
        return Flux.fromIterable(orderService.findAll());
    }

    @GetMapping("/{id}")
    public Mono<Order> getOrderById(@PathVariable("id") UUID id) {
        return Mono.fromCallable(()->orderService.findById(id).orElse(null));
    }

    @PostMapping
    public Mono<Order> saveOrder(@RequestBody Order order) {
        return Mono.fromCallable(()->orderService.save(order));
    }

    @PutMapping("/{id}")
    public Mono<Order> updateOrder(@PathVariable("id") UUID id, @RequestBody Order order) {
        return Mono.fromCallable(()->orderService.updateById(id, order).orElse(null));
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteOrder(@PathVariable("id") UUID id) {
        return Mono.fromRunnable(()->orderService.delete(id));
    }

}
