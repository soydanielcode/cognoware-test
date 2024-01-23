package com.cognoware.test.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "persona")
@Getter
@Setter
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona", nullable = false, unique = true)
    private Integer idPerson;
    @Column(name = "cedula", nullable = false, unique = true, length = 10)
    private String passport;
    @Column(name = "nombres", length = 20)
    private String names;
    @Column(name = "apellidos", length = 20)
    private String lastName;
    @Column(name = "direccion", length = 40)
    private String address;
    @Column(name = "celular", length = 10)
    private String phoneNumber;
    @Column(name = "correo",unique = true, length = 40)
    private String email;
    @Column(name = "fecha_nacimiento", columnDefinition = "DATETIME")
    private LocalDateTime birthdate;
}
