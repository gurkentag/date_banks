package com.example.dataloader.idsClasses;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

public class Books_authorsId implements Serializable {
    private String productNummer;
    private Integer authorId;

    // Konstruktor, Getter und Setter

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Books_authorsId that = (Books_authorsId) o;
        return Objects.equals(productNummer, that.productNummer) && Objects.equals(authorId, that.authorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productNummer, authorId);
    }
}