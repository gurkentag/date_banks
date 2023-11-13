package com.example.dataloader.repositories;

import com.example.dataloader.entities.DVDProperties;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DVDPropertiesRep extends JpaRepository<DVDProperties,String> {
}
