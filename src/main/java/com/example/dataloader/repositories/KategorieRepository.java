package com.example.dataloader.repositories;
import com.example.dataloader.entities.Authors;
import com.example.dataloader.entities.Kategorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface KategorieRepository extends JpaRepository<Kategorie, Integer> {
    List<Kategorie> findByKategoriename(String kategoriename);
}
