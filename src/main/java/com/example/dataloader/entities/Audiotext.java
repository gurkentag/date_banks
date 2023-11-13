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
public class Audiotext {
    @Id
    @GeneratedValue(generator = "INTEGER")
    @Column(name = "audiotextid")
    private Integer id;
    @Column(name = "audioformat")
    private String audioformat;
    @Column(name = "languages")
    private String languages;
}
