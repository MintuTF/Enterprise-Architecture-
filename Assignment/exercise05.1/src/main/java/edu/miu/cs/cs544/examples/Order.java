package edu.miu.cs.cs544.examples;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private Date date;
    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;
    @OneToMany
    @JoinColumn(name = "order_id")
    private List<OrderLine> orderLines=new ArrayList<>();



    public Order(Date date) {
        this.date = date;
    }

    public boolean addOrderList(OrderLine orderLine){
        return orderLines.add(orderLine);
    }

    public boolean removeOrderList(OrderLine orderLine){
        return orderLines.remove(orderLine);
    }
}
