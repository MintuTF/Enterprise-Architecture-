package edu.miu.cs.cs544.ManyToManyBI;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Course")
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Course {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String courseNumber;
    private String name;
    @ManyToMany(mappedBy = "courses")
    private List<Student> students=new ArrayList<>();


    public Course(String courseNumber, String name) {
        this.courseNumber = courseNumber;
        this.name = name;
    }

    public void addSingleStudent(Student student){
        students.add(student);

    }

    public void removeSingleStudent(Student student){
        students.remove(student);
    }

}
