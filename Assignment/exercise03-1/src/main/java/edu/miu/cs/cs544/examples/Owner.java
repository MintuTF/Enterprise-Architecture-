package edu.miu.cs.cs544.examples;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@ToString
@EqualsAndHashCode
public class Owner {

    @Id
    @GeneratedValue
    private int id;
    @Column
    private String name;
    @Column
    private String address;

    public Owner(){

    }

    public Owner(String name,String address){
        this.name=name;
        this.address=address;
    }

    public void setName(String name){
        this.name=name;
    }
    public void setAddress(String address){
        this.address=address;
    }




}