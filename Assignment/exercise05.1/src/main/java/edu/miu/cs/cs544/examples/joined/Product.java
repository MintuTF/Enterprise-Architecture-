package edu.miu.cs.cs544.examples.joined;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Table(name="product_join_table")
@ToString
@Inheritance(strategy=InheritanceType.JOINED)
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id ;
    private String name ;
    private String description;

    public Product(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
