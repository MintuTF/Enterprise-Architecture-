package edu.miu.cs.cs544.examples.singleTable;


import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DVD")
@NoArgsConstructor
public class DVD extends Product {

    private String genre;

    public DVD(String name, String description, String genre) {
        super(name, description);
        this.genre = genre;
    }
}
