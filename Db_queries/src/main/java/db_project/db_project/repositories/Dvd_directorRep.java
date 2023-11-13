package db_project.db_project.repositories;


import db_project.db_project.entities.Dvd_director;
import db_project.db_project.idsClasses.Dvd_directorId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Dvd_directorRep extends JpaRepository<Dvd_director, Dvd_directorId> {
}
