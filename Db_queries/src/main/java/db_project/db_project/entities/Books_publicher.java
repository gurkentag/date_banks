package db_project.db_project.entities;


import db_project.db_project.idsClasses.Books_publicherId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@IdClass(Books_publicherId.class)
public class Books_publicher {
    @Id
    @Column(name ="productnummer")
    private String productNummer;
    @Id
    @Column(name ="publicherid")
    private Integer publicherId;
}
