package com.example.dataloader.repositories;

import com.example.dataloader.entities.Authors;
import com.example.dataloader.entities.Bewertung;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorsRep extends JpaRepository<Authors,Integer> {

    List<Authors> findByAname(String aname);
}
