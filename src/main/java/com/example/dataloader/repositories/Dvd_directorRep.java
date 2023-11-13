package com.example.dataloader.repositories;

import com.example.dataloader.entities.Bewertung;
import com.example.dataloader.entities.Dvd_director;
import com.example.dataloader.idsClasses.Dvd_directorId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Dvd_directorRep extends JpaRepository<Dvd_director, Dvd_directorId> {
}
