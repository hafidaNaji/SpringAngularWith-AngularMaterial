package net.naji.ensetdemospringangular2.repository;

import net.naji.ensetdemospringangular2.entities.Payment;
import net.naji.ensetdemospringangular2.entities.PaymentStatus;
import net.naji.ensetdemospringangular2.entities.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByStudentCode(String code);
    List<Payment> findByStatus(PaymentStatus status);
    List<Payment> findByType(PaymentType type);
}
