package db_project.db_project.repositories;

import db_project.db_project.entities.ÄhnlicheProdukte;
import db_project.db_project.idsClasses.ÄhnlicheProdukteId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ÄhnlicheProducteRepository extends JpaRepository<ÄhnlicheProdukte, ÄhnlicheProdukteId> {
}
