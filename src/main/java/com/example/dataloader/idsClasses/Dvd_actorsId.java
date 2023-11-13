package com.example.dataloader.idsClasses;

import java.io.Serializable;
import java.util.Objects;

public class Dvd_actorsId implements Serializable {
    private String productNummer;
    private Integer actorId;

    // Konstruktor, Getter und Setter

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dvd_actorsId that = (Dvd_actorsId) o;
        return Objects.equals(productNummer, that.productNummer) && Objects.equals(actorId, that.actorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productNummer, actorId);
    }
}