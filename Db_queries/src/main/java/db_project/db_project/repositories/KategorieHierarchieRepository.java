package db_project.db_project.repositories;

import db_project.db_project.entities.KategorieHierarchie;
import db_project.db_project.idsClasses.KategorieHierarchieId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface KategorieHierarchieRepository extends JpaRepository<KategorieHierarchie, KategorieHierarchieId> {
}
