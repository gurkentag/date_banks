package db_project.db_project.idsClasses;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class KaufId implements Serializable {
    private Integer filialId;
    private String productnummer;
    private Integer kundenumber;
    private Date datum;

    // Konstruktor, Getter und Setter

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KaufId that = (KaufId) o;
        return Objects.equals(filialId, that.filialId) && Objects.equals(productnummer, that.productnummer) && Objects.equals(kundenumber, that.kundenumber) && Objects.equals(datum, that.datum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filialId, productnummer, kundenumber, datum);
    }
}
