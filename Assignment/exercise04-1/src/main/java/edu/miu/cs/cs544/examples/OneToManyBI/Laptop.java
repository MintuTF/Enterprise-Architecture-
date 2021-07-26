package edu.miu.cs.cs544.examples.OneToManyBI;

import edu.miu.cs.cs544.examples.OneToManyBI.Employee;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@NoArgsConstructor
public class Laptop {

@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String brand;
    private String type;
    @ManyToOne
    private Employee employee;

    public Laptop(String brand, String type) {
        this.brand = brand;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }



}
