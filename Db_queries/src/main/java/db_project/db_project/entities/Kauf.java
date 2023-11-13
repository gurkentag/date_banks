package db_project.db_project.entities;

import db_project.db_project.idsClasses.KaufId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@IdClass(KaufId.class)
public class Kauf {
    @Id
    private Integer filialId;
    @Id
    private String productnummer;
    @Id
    private Integer kundenumber;
    @Id
    private Date datum;
}
