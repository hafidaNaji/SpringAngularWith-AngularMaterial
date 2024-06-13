package net.naji.ensetdemospringangular2.dtos;

import jakarta.persistence.*;
import lombok.*;
import net.naji.ensetdemospringangular2.entities.PaymentStatus;
import net.naji.ensetdemospringangular2.entities.PaymentType;
import net.naji.ensetdemospringangular2.entities.Student;

import java.time.LocalDate;


@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString @Builder
public class PaymentDTO {

    private  Long id;
    private LocalDate date;
    private double amount;
    private PaymentType type;
    private PaymentStatus status;

}
