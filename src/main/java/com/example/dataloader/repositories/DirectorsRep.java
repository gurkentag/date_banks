package com.example.dataloader.repositories;

import com.example.dataloader.entities.Directors;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DirectorsRep extends JpaRepository<Directors,Integer> {
    List<Directors> findByDname(String dname);
}
