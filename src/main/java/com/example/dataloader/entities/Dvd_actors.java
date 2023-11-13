package com.example.dataloader.entities;

import com.example.dataloader.idsClasses.Dvd_actorsId;
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
@IdClass(Dvd_actorsId.class)
public class Dvd_actors {
    @Id
    @Column(name ="productnummer")
    private String productNummer;
    @Id
    @Column(name ="actorid")
    private Integer actorId;
}
