package com.example.dataloader.repositories;
import com.example.dataloader.entities.Filiale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FilialeRepository extends JpaRepository<Filiale, Integer> {
}
