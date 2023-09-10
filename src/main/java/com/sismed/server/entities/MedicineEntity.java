package com.sismed.server.entities;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;
import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user")
@Data 
public class MedicineEntity {

    @Id 
    @GeneratedValue
    @UuidGenerator(style =UuidGenerator.Style.TIME)
    private UUID id;

    private String name;

    private LocalDate expeditionDate;

    private String laboratory;

    private String description;

    private Integer batch;

    @ManyToOne (cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "userEntity_id")
    private UserEntity user;
    
}
