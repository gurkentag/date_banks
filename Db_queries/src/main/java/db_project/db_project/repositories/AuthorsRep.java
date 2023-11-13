package db_project.db_project.repositories;


import db_project.db_project.entities.Authors;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorsRep extends JpaRepository<Authors,Integer> {

    List<Authors> findByAname(String aname);
}
