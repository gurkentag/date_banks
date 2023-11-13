package com.example.dataloader.entities;

import com.example.dataloader.idsClasses.ÄhnlicheProdukteId;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@IdClass(ÄhnlicheProdukteId.class)
@Table(name="ähnlicheprodukte")
public class ÄhnlicheProdukte {
    @Id
    private String product1id;
    @Id
    private String product2id;

}
