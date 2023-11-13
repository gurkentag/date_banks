package com.example.dataloader.repositories;
import com.example.dataloader.entities.KategorieHierarchie;
import com.example.dataloader.idsClasses.KategorieHierarchieId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface KategorieHierarchieRepository extends JpaRepository<KategorieHierarchie, KategorieHierarchieId> {
}
