package com.example.dataloader.repositories;

import com.example.dataloader.entities.Authors;
import com.example.dataloader.entities.Bewertung;
import com.example.dataloader.entities.Creators;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreatorsRep extends JpaRepository<Creators,Integer> {
    List<Creators> findByCname(String cname);
}
