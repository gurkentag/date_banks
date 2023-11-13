package com.example.dataloader.repositories;

import com.example.dataloader.entities.Kauf;
import com.example.dataloader.idsClasses.KaufId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KaufRep extends JpaRepository<Kauf, KaufId> {
}
