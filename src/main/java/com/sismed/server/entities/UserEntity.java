package com.sismed.server.entities;

import java.util.UUID;
import org.hibernate.annotations.UuidGenerator;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.*;
import lombok.Data;

/* MODELO DE LA TABLA INVOICE */

@Entity
@Table(name = "user") // Nombre de la tabla en la base de datos
@Data

public class UserEntity {   // Nombre de la tabla en la base de datos

    @Id
    @GeneratedValue
    @UuidGenerator(style =UuidGenerator.Style.TIME)     // Generador de UUID
    private UUID id;

    @NotBlank(message= "username no puede estar en blanco")     // Validación de campos
    
    private String username;    // Nombre de usuario

    private String userRol;     // Rol de usuario

    private String firstName;   // Nombre

    private String lastName;    // Apellido

    private String email;    // Correo electrónico

    private String password;   // Contraseña

    private String telephone;   // Teléfono

    private String Address;     // Dirección

    private String DNI;     // DNI
}
