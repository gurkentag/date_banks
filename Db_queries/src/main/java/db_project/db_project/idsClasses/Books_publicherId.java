package db_project.db_project.idsClasses;
import java.io.Serializable;
import java.util.Objects;

public class Books_publicherId implements Serializable {
    private String productNummer;
    private Integer publicherId;

    // Konstruktor, Getter und Setter

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Books_publicherId that = (Books_publicherId) o;
        return Objects.equals(productNummer, that.productNummer) && Objects.equals(publicherId, that.publicherId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productNummer, publicherId);
    }
}
