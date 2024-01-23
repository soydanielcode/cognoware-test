package com.cognoware.test.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "persona")
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

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Company company;

    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDateTime birthdate) {
        this.birthdate = birthdate;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
