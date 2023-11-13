package db_project.db_project.idsClasses;
import java.io.Serializable;
import java.util.Objects;

public class Cd_creatorId implements Serializable {
    private String productNummer;
    private Integer creatorId;

    // Konstruktor, Getter und Setter

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cd_creatorId that = (Cd_creatorId) o;
        return Objects.equals(productNummer, that.productNummer) && Objects.equals(creatorId, that.creatorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productNummer, creatorId);
    }
}
