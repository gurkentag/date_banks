package com.example.dataloader.idsClasses;
import java.io.Serializable;
import java.util.Objects;

public class KategorieHierarchieId implements Serializable {
    private Integer elternid;
    private Integer kinderid;

    // Konstruktor, Getter und Setter

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KategorieHierarchieId that = (KategorieHierarchieId) o;
        return Objects.equals(elternid, that.elternid) && Objects.equals(kinderid, that.kinderid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elternid, kinderid);
    }
}

