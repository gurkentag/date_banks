package db_project.db_project.entities;

import db_project.db_project.idsClasses.CdsTracksId;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@IdClass(CdsTracksId.class)
public class Cds_tracks {
    @Id
    @Column(name = "trackid")
    private Integer id;
    @Id
    @Column(name ="productnummer")
    private String productNummer;

}
