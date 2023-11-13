package com.example.dataloader.entities;

import com.example.dataloader.idsClasses.VerfügbarkeitId;
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
