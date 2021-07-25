package edu.miu.cs.cs544.ManyToManyBI;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Student")
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long studentId;
    private String firstname;
    private String lastname;
    @ManyToMany
    @JoinTable(name="Course_student",
            joinColumns = {
            @JoinColumn(name="stu_id")
    },
            inverseJoinColumns =   {@JoinColumn(name="course_id")}
    )
    private List<Course> courses=new ArrayList<>();

    public Student(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

   public boolean addCourse(Course course){

        course.addSingleStudent(this);
        return courses.add(course);
   }

   public boolean removeCourse(Course course){
        course.removeSingleStudent(this);
        return courses.remove(course);
   }


}
