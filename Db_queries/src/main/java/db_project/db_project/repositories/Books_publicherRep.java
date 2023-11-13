package db_project.db_project.repositories;


import db_project.db_project.entities.Books_publicher;
import db_project.db_project.idsClasses.Books_publicherId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Books_publicherRep extends JpaRepository<Books_publicher, Books_publicherId> {
}
