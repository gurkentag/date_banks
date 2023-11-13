package db_project.db_project.repositories;


import db_project.db_project.entities.Actors;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ActorsRep extends JpaRepository<Actors,Integer> {
    List<Actors> findByAname(String aname);
}
