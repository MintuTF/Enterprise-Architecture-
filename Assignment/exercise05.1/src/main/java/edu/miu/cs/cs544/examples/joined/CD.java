package edu.miu.cs.cs544.examples.joined;



import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity

@NoArgsConstructor
public class CD extends Product {
    private String artist;

    public CD(String name, String description, String artist) {
        super(name, description);
        this.artist = artist;
    }
    
}
