package com.example.dataloader.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Kunde {
    @Id
    @GeneratedValue(generator = "INTEGER")
    @Column(name = "accountnumber")
    private Integer id;
    private String kontonummer;
    private String lieferadresse;
    private String username;
}
