package db_project.db_project.entities;

import db_project.db_project.idsClasses.VerfügbarkeitId;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@IdClass(VerfügbarkeitId.class)
public class Verfügbarkeit {
    @Id
    private String productnummer;
    @Id
    private Integer filialid;

    private Integer productanzahl;
    @Id
    private double preis;
    private String zustand;
}
