package com.sismed.server.entities;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Delivery")
@Data
public class DeliveryEntity{
    
    @Id 
    @GeneratedValue
    @UuidGenerator(style =UuidGenerator.Style.TIME)
    private UUID id;

    private String VehicleLicensePlate;

    private String VehicleType;
    
    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "MedicineEntity_id")
    private UserEntity user;

}