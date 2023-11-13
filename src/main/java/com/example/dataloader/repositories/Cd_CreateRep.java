package com.example.dataloader.repositories;

import com.example.dataloader.entities.Cd_creator;

import com.example.dataloader.idsClasses.Cd_creatorId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Cd_CreateRep extends JpaRepository<Cd_creator, Cd_creatorId> {
}
