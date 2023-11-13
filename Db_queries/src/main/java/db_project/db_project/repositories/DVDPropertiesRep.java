package db_project.db_project.repositories;


import db_project.db_project.entities.DVDProperties;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DVDPropertiesRep extends JpaRepository<DVDProperties,String> {
}
