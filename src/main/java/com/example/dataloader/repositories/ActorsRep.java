package com.example.dataloader.repositories;

import com.example.dataloader.entities.Actors;
import com.example.dataloader.entities.Authors;
import com.example.dataloader.entities.Dvd_creator;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ActorsRep extends JpaRepository<Actors,Integer> {
    List<Actors> findByAname(String aname);
}
