package db_project.db_project.repositories;


import db_project.db_project.entities.Tracks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TracksRep extends JpaRepository<Tracks,Integer> {

    List<Tracks> findByTitel(String titel);
}
