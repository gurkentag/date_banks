package db_project.db_project.repositories;

import db_project.db_project.entities.Books_authors;
import db_project.db_project.idsClasses.Books_authorsId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Books_authorsRep extends JpaRepository<Books_authors, Books_authorsId> {
}
