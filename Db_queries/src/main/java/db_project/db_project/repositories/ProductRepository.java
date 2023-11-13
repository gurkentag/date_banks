package db_project.db_project.repositories;


import db_project.db_project.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, String> {
}
