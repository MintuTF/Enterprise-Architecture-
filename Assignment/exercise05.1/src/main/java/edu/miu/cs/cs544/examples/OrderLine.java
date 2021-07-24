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
public class OrderLine {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String quantity;
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;



    public OrderLine(String quantity) {
        this.quantity = quantity;
    }
}
