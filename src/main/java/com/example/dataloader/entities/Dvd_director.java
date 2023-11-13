package com.example.dataloader.entities;

import com.example.dataloader.idsClasses.Dvd_directorId;
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
@IdClass(Dvd_directorId.class)
public class Dvd_director {
    @Id
    @Column(name ="productnummer")
    private String productNummer;
    @Id
    @Column(name ="directorid")
    private Integer directorId;
}
