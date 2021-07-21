package src;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter @Setter @NoArgsConstructor
@ToString @EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Book {



    @Id
    private int id;
    private String title;
    private String ISBM;
    private String author;
    private double price;
    private Date publish_date;


}
