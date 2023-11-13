package db_project.db_project.idsClasses;

import java.io.Serializable;
import java.util.Objects;

public class Dvd_directorId implements Serializable {
    private String productNummer;
    private Integer directorId;

    // Konstruktor, Getter und Setter

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dvd_directorId that = (Dvd_directorId) o;
        return Objects.equals(productNummer, that.productNummer) && Objects.equals(directorId, that.directorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productNummer, directorId);
    }
}

