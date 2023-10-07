package com.sismed.server.entities;

import java.util.UUID;
import org.hibernate.annotations.UuidGenerator;
import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.Data;

/* MODELO DE LA TABLA MEDICINE */

@Entity
@Table(name = "user")
@Data 

public class MedicineEntity {   // Clase MedicineEntity

    @Id
    @GeneratedValue
    @UuidGenerator(style =UuidGenerator.Style.TIME)     // Generador de UUID
    private UUID id;

    private String name;    // Atributos de la tabla Medicine

    private LocalDate expeditionDate;   // Atributos de la tabla Medicine

    private String laboratory;  // Atributos de la tabla Medicine

    private String description; // Atributos de la tabla Medicine

    private Integer batch;  // Atributos de la tabla Medicine

    @ManyToOne (cascade = CascadeType.MERGE, fetch = FetchType.LAZY)    // Relación con la tabla User
    @JoinColumn(name = "userEntity_id")     // Llave foránea
    private UserEntity user;

}
