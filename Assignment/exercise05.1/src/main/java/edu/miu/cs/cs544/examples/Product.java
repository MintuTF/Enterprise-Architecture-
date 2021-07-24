package edu.miu.cs.cs544.examples;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Table(name="orderline")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id ;
    private String name ;
    private String description;

    public Product(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
