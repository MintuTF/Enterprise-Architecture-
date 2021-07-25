package edu.miu.cs.cs544.examples.singleTable;


import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Book")
@NoArgsConstructor
public class Book  extends Product {

    private String title;

    public Book(String name, String description, String title) {
        super(name, description);
        this.title = title;
    }
}
