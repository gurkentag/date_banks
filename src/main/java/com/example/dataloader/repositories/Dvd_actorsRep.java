package com.example.dataloader.repositories;

import com.example.dataloader.entities.Dvd_actors;
import com.example.dataloader.entities.Dvd_creator;
import com.example.dataloader.idsClasses.Dvd_actorsId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Dvd_actorsRep extends JpaRepository<Dvd_actors, Dvd_actorsId> {
}
