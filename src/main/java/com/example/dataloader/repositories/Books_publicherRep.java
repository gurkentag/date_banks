package com.example.dataloader.repositories;

import com.example.dataloader.entities.Bewertung;
import com.example.dataloader.entities.Books_publicher;
import com.example.dataloader.idsClasses.Books_publicherId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Books_publicherRep extends JpaRepository<Books_publicher, Books_publicherId> {
}
