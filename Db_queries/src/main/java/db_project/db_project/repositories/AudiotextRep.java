package db_project.db_project.repositories;

import db_project.db_project.entities.Audiotext;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AudiotextRep extends JpaRepository<Audiotext,Integer> {
}
