package edu.miu.cs.cs544.OneToMany;

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
    @OneToMany(mappedBy = "department",cascade=CascadeType.PERSIST)
    private List<Employee> employees=new ArrayList<>();


    public Department(String name) {
        this.name = name;
    }

    public boolean addEmployee(Employee employee){
        employee.setDepartment(this);
        return employees.add(employee);
   }

   public boolean removeEmployee(Employee employee){
        employee.setDepartment(null);
        return employees.remove(employee);
   }

}
