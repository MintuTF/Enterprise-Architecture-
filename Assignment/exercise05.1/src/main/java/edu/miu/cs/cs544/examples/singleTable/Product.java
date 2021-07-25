package edu.miu.cs.cs544.examples.singleTable;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Table(name="product")
@ToString
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "product_type",
        discriminatorType = DiscriminatorType.STRING
)
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
