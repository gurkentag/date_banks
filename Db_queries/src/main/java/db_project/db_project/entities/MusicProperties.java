package db_project.db_project.entities;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="musicproperties")
public class MusicProperties {
    @Id
    @Column(name ="productnummer")
    private String productnummer;
    private String binding;
    @Column(name ="releasedate")
    private String releaseDate;
    @Column(name ="numdiscs")
    private String numDiscs;
    @Column(name ="productlabel")
    private String productlabel;
    private String format;
    private String ups;
}
