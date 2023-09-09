package com.sismed.server.entities;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;
import jakarta.validation.constraints.NotBlank;

import jakarta.persistence.*;
import lombok.Data;

public class MedicineTypeEntity{

    @Id 
    @GeneratedValue
    @UuidGenerator(style =UuidGenerator.style.TIME)
    private UUID id;

    private String category;

    private String amount;
    
    private String availability;

    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "MedicineEntity_id")
    private MedicineEntity medicine;

}
