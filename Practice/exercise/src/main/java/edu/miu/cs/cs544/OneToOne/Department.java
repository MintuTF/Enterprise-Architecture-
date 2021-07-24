package edu.miu.cs.cs544.OneToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Departments")
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @OneToOne(mappedBy = "department")
    private Employee employee;


    public Department(String name) {
        this.name = name;
    }



}
