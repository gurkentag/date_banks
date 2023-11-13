package db_project.db_project.repositories;


import db_project.db_project.entities.Directors;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DirectorsRep extends JpaRepository<Directors,Integer> {
    List<Directors> findByDname(String dname);
}
