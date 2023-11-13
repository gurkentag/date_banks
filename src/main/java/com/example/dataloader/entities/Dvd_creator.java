package com.example.dataloader.entities;

import com.example.dataloader.idsClasses.Dvd_creatorId;
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
@IdClass(Dvd_creatorId.class)
public class Dvd_creator {
    @Id
    @Column(name ="productnummer")
    private String productNummer;
    @Id
    @Column(name ="creatorid")
    private Integer creatorId;
}
