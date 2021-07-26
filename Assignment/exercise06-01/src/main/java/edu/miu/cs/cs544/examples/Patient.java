package edu.miu.cs.cs544.examples;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString

@SecondaryTables(
        @SecondaryTable(name="address", pkJoinColumns = {
                @PrimaryKeyJoinColumn(name="address_id", referencedColumnName="id")
        }
        ))
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(table = "address")
    private String street;
    @Column(table = "address")
    private String zip;
    @Column(table = "address")
    private String city;


    public Patient(String name, String street, String zip, String city) {
        this.name = name;
        this.street = street;
        this.zip = zip;
        this.city = city;
    }
}
