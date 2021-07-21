package src;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity @Getter
@Setter @NoArgsConstructor
@EqualsAndHashCode
@Table(name = "Car")
public class Car {



    @Id
    @GeneratedValue
private String id;

    @Column
private String brand;
    @Column
private int year;
    @Column
private  double price;




}
