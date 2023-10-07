package com.sismed.server.entities;

import java.util.UUID;
import org.hibernate.annotations.UuidGenerator;
import jakarta.persistence.*;
import lombok.Data;

/* MODELO DE LA TABLA DELIVERY */

@Entity
@Table(name = "Delivery")
@Data

public class DeliveryEntity{    // Entidad de la tabla Delivery

    @Id
    @GeneratedValue
    @UuidGenerator(style =UuidGenerator.Style.TIME)     // Generador de UUID
    private UUID id;

    private String vehicleLicensePlate;     // Placa del vehiculo

    private String vehicleType;     // Tipo de vehiculo


    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY) // Relacion uno a uno con la tabla User
    @JoinColumn(name = "MedicineEntity_id")
    private UserEntity user;

}