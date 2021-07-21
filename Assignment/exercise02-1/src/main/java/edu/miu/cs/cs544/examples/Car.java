package edu.miu.cs.cs544.examples;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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

    public Car(String brand,int year,double price){
        this.brand=brand;
        this.year=year;
        this.price=price;
    }


}
