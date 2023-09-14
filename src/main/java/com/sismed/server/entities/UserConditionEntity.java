package com.sismed.server.entities;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;
import jakarta.validation.constraints.NotBlank;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "userCondition")
@Data
public class UserConditionEntity {

    @Id
    @GeneratedValue
    @UuidGenerator(style =UuidGenerator.Style.TIME)
    private UUID id;

    @NotBlank(message= "username no puede estar en blanco")
    private String username;

    private String observation;

    private String userCondition;

}
