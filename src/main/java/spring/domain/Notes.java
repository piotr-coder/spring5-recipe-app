package spring.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * Created by Piotr on 2020-06-25
 */
@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne   // we dont want "(cascade =" because it will delete Recipe after deleting Notes :)
    private Recipe recipe;

    @Lob        // Large Object => by default Hibernate and JPA limit is 255 characters
    private String recipeNotes;

}
