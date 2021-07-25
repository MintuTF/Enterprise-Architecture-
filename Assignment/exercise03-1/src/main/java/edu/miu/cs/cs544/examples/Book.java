package edu.miu.cs.cs544.examples;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity

@Getter
@Setter

@ToString
public class Book {

    @Id
    @GeneratedValue
        private long id;
    @Column
        private String title;
    @Column
        private int ISBN;
    @Column
        private String author;
    @Column
        private double price;
    @Temporal(TemporalType.DATE)
        private Date publish_date;
public Book(){

}
    public Book(String title, int ISBN,String author,double price ,Date publish_date){
 this.title=title;
 this.ISBN=ISBN;
 this.author=author;
 this.price=price;
 this.publish_date=publish_date;

    }

}
