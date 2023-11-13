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
public class Actors {
    @Id
    @GeneratedValue(generator = "INTEGER")
    @Column(name = "actorid")
    private Integer id;

    @Column(name = "aname")
    private String aname;
}
