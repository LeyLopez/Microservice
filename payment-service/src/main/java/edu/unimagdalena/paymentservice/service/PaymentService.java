package edu.unimagdalena.paymentservice.service;

import edu.unimagdalena.paymentservice.entity.Payment;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PaymentService {
    List<Payment> findAll();

    Optional<Payment> findById(UUID id);

    Payment save(Payment payment);

    void deleteById(UUID id);

    Optional<Payment> updateById(UUID id, Payment payment);

}
