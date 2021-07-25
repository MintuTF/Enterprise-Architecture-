package edu.miu.cs.cs544.OneToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Employees")
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long employeeNumber;
    private String name;
    @OneToOne
    @JoinColumn(name="department_id")
  private Department department;

    public Employee(String name) {
        this.name = name;

    }
}
