package edu.miu.cs.cs544.examples;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate appdate;
    @ManyToOne(cascade = CascadeType.ALL)
    private Patient patient;
   @Embedded
    private Payment payment;
    @ManyToOne(cascade = CascadeType.ALL)
    private Doctor doctor;

    public Appointment(LocalDate appdate, Patient patient, Payment payment, Doctor doctor) {
        this.appdate = appdate;
        this.patient = patient;
        this.payment = payment;
        this.doctor = doctor;
    }
}