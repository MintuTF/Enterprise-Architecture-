package edu.miu.cs.cs544.examples;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Payment {

    private LocalDate paydate;
    private double amount;


    public Payment(LocalDate paydate, double amount) {
        this.paydate = paydate;
        this.amount = amount;
    }
}