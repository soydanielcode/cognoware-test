package com.cognoware.test.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "empresa")
@Getter
@Setter
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa", unique = true, nullable = false)
    private Integer idCompany;

    @Column(name = "id_persona", unique = true, nullable = false)
    private Integer idPerson;

    @Column(name = "nombre", length = 30, unique = true, nullable = false)
    private String name;

    @Column(name = "celular", length = 10)
    private String phoneNumber;

    @Column(name = "direccion", length = 40)
    private String address;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Person> persons;

}
