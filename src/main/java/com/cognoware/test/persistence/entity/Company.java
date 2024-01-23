package com.cognoware.test.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "empresa")
@Getter
@Setter
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa")
    private Integer idCompany;
    @Column(name = "nombre", length = 30, unique = true, nullable = false)
    private String name;
    @Column(name = "celular", length = 10)
    private String phoneNumber;
    @Column(name = "direccion", length = 40)
    private String address;
}
