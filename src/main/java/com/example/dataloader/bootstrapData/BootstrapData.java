package com.example.dataloader.bootstrapData;

import com.example.dataloader.entities.Bewertung;
import com.example.dataloader.entities.Kauf;
import com.example.dataloader.entities.Kunde;
import com.example.dataloader.repositories.*;
import com.example.dataloader.services.ReviewReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class BootstrapData  {

    private final ReviewReader reviewReader;
    private final BewertungsRepository bewertungsRepository;
    private final KundeRepository kundeRepository;
    private final KaufRep kaufRep;
    private final FilialeRepository filialeRepository;
    private final VerfügbarkeitsRepository verfügbarkeitsRepository;
    public void speichereGeleseneFile() throws IOException {
        List<Bewertung> bewertungs =  reviewReader.readCSVFile("data/reviews.csv");
       bewertungs.stream()

               .map(bewertung -> bewertung.getUsername())
               .filter(name-> !name.equals("guest"))
               .distinct()
               .map(name-> Kunde.builder()
                        .username(name)
                        .build())
               .map(kunde -> kundeRepository.save(kunde))
                .toList();

        bewertungs.forEach(bewertung->{
            try {
                bewertungsRepository.save(bewertung);
                saveKauf(bewertung);
            }
            catch (Exception e){
                System.out.println("Can not insert into Bewertung. " + e.getMessage());
            }
    });
    }

    public void saveKauf(Bewertung bewertung){
        LocalDate randomDate = LocalDate.now(); // Enddatum (heutiges Datum)
        var kunde = kundeRepository.findByUsername(bewertung.getUsername()).stream().findFirst();
        var verfügbarkeit = verfügbarkeitsRepository.findByProductnummer(bewertung.getProductnummer()).stream().findFirst();

        if(verfügbarkeit.isEmpty() || kunde.isEmpty()){
            return;
        }

        var kauf = Kauf.builder()
                .productnummer(bewertung.getProductnummer())
                .filialId(verfügbarkeit.get().getFilialid())
                .kundenumber(kunde.get().getId())
                .datum(Date.valueOf(randomDate))
                .build();

        kaufRep.save(kauf);
    }
}
