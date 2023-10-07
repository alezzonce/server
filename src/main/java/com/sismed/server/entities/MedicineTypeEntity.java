package com.sismed.server.entities;

import java.util.UUID;
import org.hibernate.annotations.UuidGenerator;
import jakarta.persistence.*;
import lombok.Data;

/* MODELO DE LA TABLA MEDICINE TYPE */

@Entity
@Table(name = "MedicineType") // Nombre de la tabla
@Data

public class MedicineTypeEntity{    // Clase de la tabla

    @Id
    @GeneratedValue
    @UuidGenerator(style =UuidGenerator.Style.TIME)     // Generador de UUID
    private UUID id;    

    private String category;    // Categoria

    private String amount;  // Cantidad

    private String availability;    // Disponibilidad

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)     // Relacion de muchos a uno
    @JoinColumn(name = "MedicineEntity_id")     // Nombre de la columna
    private MedicineEntity medicine;    // Relacion con la tabla MedicineEntity

}
