package edu.unimagdalena.orderservice.service;

import edu.unimagdalena.orderservice.entity.Order;
import edu.unimagdalena.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderServiceImp implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImp(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(UUID id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void delete(UUID id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Optional<Order> updateById(UUID id, Order order) {
        return orderRepository.findById(id).map(
                orderInBD->{
                    orderInBD.setProductIds(order.getProductIds());
                    orderInBD.setPaymentId(order.getPaymentId());

                    return orderRepository.save(orderInBD);
                }
        );
    }
}
