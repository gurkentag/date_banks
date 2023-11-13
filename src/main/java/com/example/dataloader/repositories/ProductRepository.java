package com.example.dataloader.repositories;

import com.example.dataloader.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, String> {
}
