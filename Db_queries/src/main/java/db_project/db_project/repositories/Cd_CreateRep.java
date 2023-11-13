package db_project.db_project.repositories;


import db_project.db_project.entities.Cd_creator;
import db_project.db_project.idsClasses.Cd_creatorId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Cd_CreateRep extends JpaRepository<Cd_creator, Cd_creatorId> {
}
