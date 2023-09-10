package com.sismed.server.entities;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "UserCondition")
@Data
public class UserConditionEntity{
    
    @Id 
    @GeneratedValue
    @UuidGenerator(style =UuidGenerator.Style.TIME)
    private UUID id;

    private String observation;

    private String userCondition;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "userEntity_id")
    private UserEntity user;

}

