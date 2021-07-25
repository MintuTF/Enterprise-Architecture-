package edu.miu.cs.cs544.examples;


import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@ToString
@NoArgsConstructor
@Table(name="Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstname;
    private String lastname;
    @OneToMany(mappedBy="employee")
    private Set<Laptop> laptopSet=new HashSet<>();

    public Employee(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public boolean addLaptop(Laptop laptop){
        boolean success = false;
        if(laptopSet.add(laptop)){
            laptop.setEmployee(this);
            success=true;
        }

        return success;

    }

    public boolean removeLaptop(Laptop laptop){
        boolean success=false;
        if(laptopSet.remove(laptop)){
            laptop.setEmployee(null);
            success=true;

        }
        return success;
    }

}
