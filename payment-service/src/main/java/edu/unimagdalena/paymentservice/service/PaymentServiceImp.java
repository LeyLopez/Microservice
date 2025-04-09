package edu.unimagdalena.paymentservice.service;

import edu.unimagdalena.paymentservice.entity.Payment;
import edu.unimagdalena.paymentservice.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PaymentServiceImp implements PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentServiceImp(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Optional<Payment> findById(UUID id) {
        return paymentRepository.findById(id);
    }

    @Override
    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public void deleteById(UUID id) {
        paymentRepository.deleteById(id);
    }

    @Override
    public Optional<Payment> updateById(UUID id, Payment payment) {
        return paymentRepository.findById(id).map(
                paymentInBD->{
                    paymentInBD.setDescription(payment.getDescription());
                    paymentInBD.setAmount(payment.getAmount());
                    paymentInBD.setTransactionId(payment.getTransactionId());

                    return paymentRepository.save(paymentInBD);
                }
        );
    }
}
