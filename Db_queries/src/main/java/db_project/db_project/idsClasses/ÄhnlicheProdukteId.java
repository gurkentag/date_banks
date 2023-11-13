package db_project.db_project.idsClasses;

import java.io.Serializable;
import java.util.Objects;

public class ÄhnlicheProdukteId implements Serializable {
    private String product1id;
    private String product2id;

    // Konstruktor, Getter und Setter

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ÄhnlicheProdukteId that = (ÄhnlicheProdukteId) o;
        return Objects.equals(product1id, that.product1id) && Objects.equals(product2id, that.product2id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product1id, product2id);
    }
}
