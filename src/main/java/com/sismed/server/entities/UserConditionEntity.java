package com.sismed.server.entities;

import java.util.UUID;
import org.hibernate.annotations.UuidGenerator;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.*;
import lombok.Data;

/* MODELO DE LA TABLA USER CONDITION */

@Entity
@Table(name = "userCondition") // Nombre de la tabla en la base de datos
@Data

public class UserConditionEntity {  // Clase de la entidad UserCondition

    @Id
    @GeneratedValue
    @UuidGenerator(style =UuidGenerator.Style.TIME)     // Generador de UUID
    private UUID id;

    @NotBlank(message= "username no puede estar en blanco")     // Validación de que el campo no esté en blanco
    
    private String username;    // Nombre de usuario

    private String observation;     // Observación

    private String userCondition;   // Condición del usuario

}
