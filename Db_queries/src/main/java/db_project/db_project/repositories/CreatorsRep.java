package db_project.db_project.repositories;


import db_project.db_project.entities.Creators;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreatorsRep extends JpaRepository<Creators,Integer> {
    List<Creators> findByCname(String cname);
}
