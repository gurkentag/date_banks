package db_project.db_project.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import java.util.Date;


@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Bewertung {

    @Id
    @GeneratedValue(generator = "INTEGER")
    @Column(name = "bewertungid")
    private Integer id;
    private String productnummer;
    private int rating;
    private int helpful;
    @Column(name = "datum")
    private Date reviewDate;

    private String username;

    private String summary;

    @Column(name = "inhalt")
    private String content;

}
