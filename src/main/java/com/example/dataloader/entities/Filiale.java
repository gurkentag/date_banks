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
public class Filiale {
    @Id
    @GeneratedValue(generator = "INTEGER")
    @Column(name = "filialid")
    private Integer id;

    private String filialname;
    private String anschrift;


}
