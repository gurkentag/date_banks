package db_project.db_project.repositories;


import db_project.db_project.entities.BookProperties;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookPropertiesRep extends JpaRepository<BookProperties,String>  {
}
