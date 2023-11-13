package com.example.dataloader.repositories;

import com.example.dataloader.entities.Bewertung;
import com.example.dataloader.entities.Cds_tracks;
import com.example.dataloader.idsClasses.CdsTracksId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Cds_tracksRep extends JpaRepository<Cds_tracks, CdsTracksId> {
}
