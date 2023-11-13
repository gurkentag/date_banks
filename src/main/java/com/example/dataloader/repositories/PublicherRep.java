package com.example.dataloader.repositories;

import com.example.dataloader.entities.Publichers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublicherRep extends JpaRepository<Publichers,Integer> {

    List<Publichers> findByPname(String publicher);
}
