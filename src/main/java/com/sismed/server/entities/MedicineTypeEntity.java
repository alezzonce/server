package com.sismed.server.entities;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "MedicineType")
@Data
public class MedicineTypeEntity{

    @Id 
    @GeneratedValue
    @UuidGenerator(style =UuidGenerator.Style.TIME)
    private UUID id;

    private String category;

    private String amount;
    
    private String availability;

    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "MedicineEntity_id")
    private MedicineEntity medicine;

}
