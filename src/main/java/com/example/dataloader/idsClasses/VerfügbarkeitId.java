package com.example.dataloader.idsClasses;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;
@Setter
@Getter
@Embeddable
public class VerfügbarkeitId implements Serializable {
    private String productnummer;
    private Integer filialid;
    private double preis;

    // Konstruktor, Getter und Setter

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VerfügbarkeitId that = (VerfügbarkeitId) o;
        return Objects.equals(productnummer, that.productnummer) && Objects.equals(filialid, that.filialid) && Objects.equals(preis, that.preis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productnummer, filialid, preis);
    }
}