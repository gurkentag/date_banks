package db_project.db_project.repositories;


import db_project.db_project.entities.Kauf;
import db_project.db_project.idsClasses.KaufId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KaufRep extends JpaRepository<Kauf, KaufId> {
}
