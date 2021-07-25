package edu.miu.cs.cs544.ManyToOne.examples;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Table(name="Owner_table")
public class Owner
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String address;


    public Owner( String name, String address) {

        this.name = name;
        this.address = address;
    }
}
