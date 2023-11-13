package db_project.db_project.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Kategorie {
    @Id
    @GeneratedValue(generator = "INTEGER")
    @Column(name = "kategorieid")
    private Integer id;
    private String kategoriename;
}
