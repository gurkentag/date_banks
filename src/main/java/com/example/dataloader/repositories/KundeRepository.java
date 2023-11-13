package com.example.dataloader.repositories;
import com.example.dataloader.entities.Kunde;
import com.example.dataloader.entities.Verfügbarkeit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface KundeRepository extends JpaRepository<Kunde, Integer> {
    List<Kunde> findByUsername(String username);
}
