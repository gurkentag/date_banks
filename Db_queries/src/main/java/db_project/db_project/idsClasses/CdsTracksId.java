package db_project.db_project.idsClasses;

import java.io.Serializable;
import java.util.Objects;

public class CdsTracksId implements Serializable {
    private Integer id;
    private String productNummer;

    // Konstruktor, Getter und Setter

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CdsTracksId that = (CdsTracksId) o;
        return Objects.equals(id, that.id) && Objects.equals(productNummer, that.productNummer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productNummer);
    }
}







