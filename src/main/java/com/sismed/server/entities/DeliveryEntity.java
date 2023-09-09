package com.sismed.server.entities;

import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;
import jakarta.validation.constraints.NotBlank;

import jakarta.persistence.*;
import lombok.Data;

public class DeliveryEntity{
    
    @Id 
    @GeneratedValue
    @UuidGenerator(style =UuidGenerator.style.TIME)
    private UUID id;

    private String VehicleLicensePlate;

    private String VehicleType;
    
    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "MedicineEntity_id")
    private UserEntity user;

}