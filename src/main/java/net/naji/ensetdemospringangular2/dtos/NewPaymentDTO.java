package net.naji.ensetdemospringangular2.dtos;

import lombok.*;
import net.naji.ensetdemospringangular2.entities.PaymentStatus;
import net.naji.ensetdemospringangular2.entities.PaymentType;

import java.time.LocalDate;


@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString @Builder
public class NewPaymentDTO {

    private  Long id;
    private LocalDate date;
    private double amount;
    private PaymentType type;
    private PaymentStatus status;
    private String studentCode;

}
