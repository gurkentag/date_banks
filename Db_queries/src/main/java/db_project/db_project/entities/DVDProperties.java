package db_project.db_project.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="dvdproperties")
public class DVDProperties {
    @Id
    @Column(name ="productnummer")
    private String productnummer;
    @Column(name ="releasedate")
    private String releaseDate;
    @Column(name ="theatricalrelease")
    private String theatricalRelease;
    @Column(name ="aspectratio")
    private String aspectRatio;
    private String format;
    private String laufzeit;
    private String regioncode;
    private String studio;
    private String ups;
}
