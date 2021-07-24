package edu.miu.cs.cs544.ManyToOne.examples;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Car_table")
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Getter
@Setter
public class Car {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String brand;
    private int year;
    @Access(AccessType.FIELD)
    private double price;
    @Transient
    private  String IgnoreThis;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="Owner_Car")

    private Owner owner;

    public Car( String brand, int year, double price) {

        this.brand = brand;
        this.year = year;
        this.price = price;
    }


}
