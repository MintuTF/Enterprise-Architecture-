package edu.miu.cs.cs544.examples.joined;

import lombok.*;

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
@ToString(exclude="customer")
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Temporal(TemporalType.DATE)
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
