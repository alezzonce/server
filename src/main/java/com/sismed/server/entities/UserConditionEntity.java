package com.sismed.server.entities;

import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;
import jakarta.validation.constraints.NotBlank;

import jakarta.persistence.*;
import lombok.Data;


public class UserConditionEntity{
    
    @Id 
    @GeneratedValue
    @UuidGenerator(style =UuidGenerator.style.TIME)
    private UUID id;

    private String observation;

    private String userCondition;

    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "userEntity_id")
    private UserEntity user;

}