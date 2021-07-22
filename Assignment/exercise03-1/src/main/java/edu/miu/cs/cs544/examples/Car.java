package edu.miu.cs.cs544.examples;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
public class Car {

    @Id
    @GeneratedValue
    private long id;
    @Column
    private String brand;
    @Column
    private  int year;
    @Column
    private double price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private  Owner owner;

    public Car(String brand,int year,double price){
        this.brand=brand;
        this.year=year;
        this.price=price;
    }


}
