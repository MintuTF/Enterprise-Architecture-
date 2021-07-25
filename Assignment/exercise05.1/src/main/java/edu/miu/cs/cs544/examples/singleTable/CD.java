package edu.miu.cs.cs544.examples.singleTable;


import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CD")
@NoArgsConstructor
public class CD extends Product {
    private String artist;

    public CD(String name, String description, String artist) {
        super(name, description);
        this.artist = artist;
    }

}
