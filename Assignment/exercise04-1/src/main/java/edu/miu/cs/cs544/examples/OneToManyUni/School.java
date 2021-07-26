package edu.miu.cs.cs544.examples.OneToManyUni;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Entity
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    @MapKey(name="studentId")
    @JoinColumn(name="school_id")
    private Map<Integer ,Student> mapStudnet=new HashMap<>();

    public School(String name, Student student) {
        this.name = name;
        this.addStudent(student);
    }

    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Map<Integer, Student> getMap() {
        return Collections.unmodifiableMap(mapStudnet);
    }

    public void setMap(Map<Integer, Student> map) {
        this.mapStudnet = map;
    }

    public Student addStudent(Student student){
       return mapStudnet.put(student.getStudentId(),student);
    }


}
