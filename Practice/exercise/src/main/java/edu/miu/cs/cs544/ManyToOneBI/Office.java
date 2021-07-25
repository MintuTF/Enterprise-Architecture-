package edu.miu.cs.cs544.ManyToOneBI;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import  javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Office")
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Office {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long roomNumber;
    private String building;
    @OneToMany(mappedBy = "office")
    private List<Employee> employees=new ArrayList<>();

    public Office(String building) {
        this.building = building;
    }

    public boolean addEmployee(Employee employee){
        employee.setOffice(this);
        return employees.add(employee);
    }
}
