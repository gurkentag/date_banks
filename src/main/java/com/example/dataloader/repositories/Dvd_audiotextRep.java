package com.example.dataloader.repositories;

import com.example.dataloader.entities.Dvd_audiotext;
import com.example.dataloader.idsClasses.Dvd_audiotextId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Dvd_audiotextRep extends JpaRepository<Dvd_audiotext, Dvd_audiotextId> {
}
