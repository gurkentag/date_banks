package com.example.dataloader.repositories;

import com.example.dataloader.entities.MusicProperties;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicPropertiesRep extends JpaRepository<MusicProperties,String> {
}
