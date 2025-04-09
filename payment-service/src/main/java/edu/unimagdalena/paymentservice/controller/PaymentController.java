package edu.unimagdalena.paymentservice.controller;

import edu.unimagdalena.paymentservice.entity.Payment;
import edu.unimagdalena.paymentservice.service.PaymentService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public Flux<Payment> getAllPayments() {
        return Flux.fromIterable(paymentService.findAll());
    }

    @GetMapping("/{id}")
    public Mono<Payment> getPaymentById(@PathVariable ("id") UUID id) {
        return Mono.fromCallable(()->paymentService.findById(id).orElse(null));
    }

    @PostMapping
    public Mono<Payment> createPayment(@RequestBody Payment payment) {
        return Mono.fromCallable(() -> paymentService.save(payment));
    }

    @PutMapping("/{id}")
    public Mono<Payment> updatePayment(@PathVariable ("id") UUID id, @RequestBody Payment payment) {
        return Mono.fromCallable(() -> paymentService.updateById(id, payment).orElse(null));
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deletePayment(@PathVariable ("id") UUID id) {
        return Mono.fromRunnable(() -> paymentService.deleteById(id));
    }
}
