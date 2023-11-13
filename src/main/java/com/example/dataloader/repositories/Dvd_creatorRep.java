package com.example.dataloader.repositories;

import com.example.dataloader.entities.Dvd_creator;
import com.example.dataloader.idsClasses.Dvd_creatorId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Dvd_creatorRep extends JpaRepository<Dvd_creator, Dvd_creatorId> {
}
