package com.example.dataloader.repositories;


import com.example.dataloader.entities.Authors;
import com.example.dataloader.entities.Verfügbarkeit;
import com.example.dataloader.idsClasses.VerfügbarkeitId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface VerfügbarkeitsRepository extends JpaRepository<Verfügbarkeit, VerfügbarkeitId> {
    List<Verfügbarkeit> findByProductnummer(String productnummer);
}
