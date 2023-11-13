package db_project.db_project.repositories;

import db_project.db_project.entities.Kunde;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface KundeRepository extends JpaRepository<Kunde, Integer> {
    List<Kunde> findByUsername(String username);
}
