package edu.miu.cs.cs544.examples.singleTable;

import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Table(name="orderline")
@ToString
public class OrderLine {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private int quantity;
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;



    public OrderLine(int quantity) {
        this.quantity = quantity;
    }
}
