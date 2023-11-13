package db_project.db_project.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @Column(name = "productnummer")
    private String productnummer;
    private Integer kategorieid;
    private String producttype;
    private String ean;
    private String titel;
    private String bild;
    private Integer verkaufsrang;
    private Integer verkaufsrating;
}
