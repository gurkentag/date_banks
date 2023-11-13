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
public class Publichers {
    @Id
    @GeneratedValue(generator = "INTEGER")
    @Column(name = "publicherid")
    private Integer publicherid;

    @Column(name = "pname")
    private String pname;
}
