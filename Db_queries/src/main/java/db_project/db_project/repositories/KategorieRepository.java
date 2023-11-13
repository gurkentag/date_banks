package db_project.db_project.repositories;

import db_project.db_project.entities.Kategorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface KategorieRepository extends JpaRepository<Kategorie, Integer> {
    List<Kategorie> findByKategoriename(String kategoriename);
}
