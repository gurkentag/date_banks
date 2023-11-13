package db_project.db_project.repositories;


import db_project.db_project.entities.Publichers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublicherRep extends JpaRepository<Publichers,Integer> {

    List<Publichers> findByPname(String publicher);
}
