package edu.miu.cs.cs544.examples.joined;



import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
public class Book  extends Product {

    private String title;

    public Book(String name, String description, String title) {
        super(name, description);
        this.title = title;
    }
}
