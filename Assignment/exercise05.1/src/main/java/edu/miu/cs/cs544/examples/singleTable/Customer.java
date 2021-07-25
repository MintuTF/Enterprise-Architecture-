package edu.miu.cs.cs544.examples.singleTable;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String firstname ;
    private String lastname;
    @OneToMany(mappedBy="customer",cascade = CascadeType.PERSIST)
    private List<Order> orders=new ArrayList<>();



    public Customer(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public boolean addOrder(Order order){
        order.setCustomer(this);
        return orders.add(order);
    }
    public boolean removeOrder(Order order){
        order.setCustomer(null);
        return orders.remove(order);
    }

}
