package edu.miu.cs.cs544.examples;

import javax.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    private long employeenumber;
    @Column
    private String name;

    @ManyToOne
    @JoinColumn
    private Department depaemployeesrtment;
    public Employee() {

    }

    public Employee( String name) {

        this.name = name;
    }

    public long getEmployeenumber() {
        return employeenumber;
    }

    private void setEmployeenumber(long employeenumber) {
        this.employeenumber = employeenumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepaemployeesrtment() {
        return depaemployeesrtment;
    }

    public void setDepaemployeesrtment(Department depaemployeesrtment) {
        this.depaemployeesrtment = depaemployeesrtment;
    }
}
