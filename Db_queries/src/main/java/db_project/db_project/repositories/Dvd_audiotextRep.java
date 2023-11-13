package db_project.db_project.repositories;


import db_project.db_project.entities.Dvd_audiotext;
import db_project.db_project.idsClasses.Dvd_audiotextId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Dvd_audiotextRep extends JpaRepository<Dvd_audiotext, Dvd_audiotextId> {
}
