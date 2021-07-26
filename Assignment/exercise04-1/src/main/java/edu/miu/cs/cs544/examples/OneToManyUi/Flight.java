package edu.miu.cs.cs544.examples.OneToManyUi;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Locale;

@Entity
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int flightNumber;
    @Column(name="from_address")
    private String from;
    @Column(name="to_address")
    private String to;
    private LocalDate date;

    public Flight(int flightNumber, String from, String to, LocalDate date) {
        this.flightNumber = flightNumber;
        this.from = from;
        this.to = to;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


}
