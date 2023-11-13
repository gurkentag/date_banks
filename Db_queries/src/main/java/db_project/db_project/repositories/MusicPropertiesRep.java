package db_project.db_project.repositories;


import db_project.db_project.entities.MusicProperties;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicPropertiesRep extends JpaRepository<MusicProperties,String> {
}
