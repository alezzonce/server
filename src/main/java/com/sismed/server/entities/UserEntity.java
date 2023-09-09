package com.sismed.server.entities;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;
import jakarta.validation.constraints.NotBlank;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class UserEntity {

    @Id 
    @GeneratedValue
    @UuidGenerator(style =UuidGenerator.Style.TIME)
    private UUID id;
 
    @NotBlank(message= "username no puede estar en blanco")
    private String username;

    private String userRol;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String telephone;

    private String Address;

    private String DNI;
}
