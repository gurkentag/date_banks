package com.example.dataloader.repositories;

import com.example.dataloader.entities.BookProperties;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookPropertiesRep extends JpaRepository<BookProperties,String>  {
}
