package com.example.dataloader.repositories;

import com.example.dataloader.entities.Bewertung;
import com.example.dataloader.entities.Books_authors;
import com.example.dataloader.idsClasses.Books_authorsId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Books_authorsRep extends JpaRepository<Books_authors, Books_authorsId> {
}
