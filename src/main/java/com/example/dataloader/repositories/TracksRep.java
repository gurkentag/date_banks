package com.example.dataloader.repositories;

import com.example.dataloader.entities.Authors;
import com.example.dataloader.entities.Bewertung;
import com.example.dataloader.entities.Tracks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TracksRep extends JpaRepository<Tracks,Integer> {

    List<Tracks> findByTitel(String titel);
}
