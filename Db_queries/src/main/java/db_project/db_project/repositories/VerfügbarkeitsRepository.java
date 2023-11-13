package db_project.db_project.repositories;
import db_project.db_project.entities.Verfügbarkeit;
import db_project.db_project.idsClasses.VerfügbarkeitId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface VerfügbarkeitsRepository extends JpaRepository<Verfügbarkeit, VerfügbarkeitId> {
    List<Verfügbarkeit> findByProductnummer(String productnummer);
}
