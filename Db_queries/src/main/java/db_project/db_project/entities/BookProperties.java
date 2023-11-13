package db_project.db_project.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="bookproperties")
public class BookProperties {
    @Id
    @Column(name ="productnummer")
    private String productnummer;
    private String binding;
    @Column(name ="seitenzahl")
    private Integer seitenzahl;
    @Column(name ="isbnnummer")
    private String isbnnummer;
    private String edition;
    private String packages;
    @Column(name ="publication1")
    private String publication;
}
