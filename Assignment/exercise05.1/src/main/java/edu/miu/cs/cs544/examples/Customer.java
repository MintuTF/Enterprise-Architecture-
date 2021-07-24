package edu.miu.cs.cs544.examples;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String firstname ;
    private String lastname;
    @OneToMany(mappedBy="customer")
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
