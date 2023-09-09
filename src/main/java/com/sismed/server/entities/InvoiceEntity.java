package com.sismed.server.entities;

import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;
import jakarta.validation.constraints.NotBlank;

import jakarta.persistence.*;
import lombok.Data;

public class InvoiceEntity{
    
    @Id 
    @GeneratedValue
    @UuidGenerator(style =UuidGenerator.style.TIME)
    private UUID id;

    private String amount;

    private LocalDate expeditionDate;
    
    private String alternativeAdress;

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "deliveryEntity_id")
    private DeliveryEntity delivery;

}