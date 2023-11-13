package db_project.db_project.repositories;


import db_project.db_project.entities.Dvd_creator;
import db_project.db_project.idsClasses.Dvd_creatorId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Dvd_creatorRep extends JpaRepository<Dvd_creator, Dvd_creatorId> {
}
