package com.example.dataloader.repositories;
import com.example.dataloader.entities.ÄhnlicheProdukte;
import com.example.dataloader.idsClasses.ÄhnlicheProdukteId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ÄhnlicheProducteRepository extends JpaRepository<ÄhnlicheProdukte, ÄhnlicheProdukteId> {
}
