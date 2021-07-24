package edu.miu.cs.cs544.ManyToOneBI;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Employee")
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Employee {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long employeeId;
    private String name;
    @ManyToOne
    @JoinColumn(name="department_id")
    private Department department;
    @ManyToOne
    @JoinColumn(name="office_id")
    private Office office;

    public Employee(String name) {
        this.name = name;

    }



}
