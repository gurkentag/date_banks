package com.example.dataloader.repositories;

import com.example.dataloader.entities.Audiotext;
import com.example.dataloader.entities.Dvd_creator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AudiotextRep extends JpaRepository<Audiotext,Integer> {
}
