package edu.miu.cs.cs544.examples.joined;



import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity

@NoArgsConstructor
public class DVD extends Product {

    private String genre;

    public DVD(String name, String description, String genre) {
        super(name, description);
        this.genre = genre;
    }
}
