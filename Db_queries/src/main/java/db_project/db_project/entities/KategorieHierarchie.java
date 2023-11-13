package db_project.db_project.entities;


import db_project.db_project.idsClasses.KategorieHierarchieId;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@IdClass(KategorieHierarchieId.class)
@Table(name="kategoriehierarchie")
public class KategorieHierarchie {
    @Id
    private Integer elternid;
    @Id
    private Integer kinderid;
}
