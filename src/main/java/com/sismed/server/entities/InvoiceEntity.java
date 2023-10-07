package com.sismed.server.entities;

import java.time.LocalDate;
import java.util.UUID;
import org.hibernate.annotations.UuidGenerator;
import jakarta.persistence.*;
import lombok.Data;

/* MODELO DE LA TABLA INVOICE */

@Entity
@Table(name = "Invoice")
@Data

public class InvoiceEntity{     // Clase InvoiceEntity

    @Id
    @GeneratedValue
    @UuidGenerator(style =UuidGenerator.Style.TIME)     // Generador de UUID
    private UUID id;

    private String amount;    // Monto

    private LocalDate expeditionDate;       // Fecha de expedición

    private String alternativeAdress;       // Dirección alternativa

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)   // Relación uno a uno con la tabla Delivery
    @JoinColumn(name = "deliveryEntity_id")
    private DeliveryEntity delivery;

}