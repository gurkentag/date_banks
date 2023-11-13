package db_project.db_project.repositories;


import db_project.db_project.entities.Dvd_actors;
import db_project.db_project.idsClasses.Dvd_actorsId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Dvd_actorsRep extends JpaRepository<Dvd_actors, Dvd_actorsId> {
}
