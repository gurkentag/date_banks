package db_project.db_project.idsClasses;
import java.io.Serializable;
import java.util.Objects;


public class Dvd_audiotextId implements Serializable {
    private String productNummer;
    private Integer audiotextId;



    // Getter und Setter

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dvd_audiotextId that = (Dvd_audiotextId) o;
        return Objects.equals(productNummer, that.productNummer) && Objects.equals(audiotextId, that.audiotextId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productNummer, audiotextId);
    }
}