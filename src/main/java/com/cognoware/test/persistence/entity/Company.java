package com.cognoware.test.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "empresa")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa", unique = true, nullable = false)
    private Integer idCompany;

    @Column(name = "nombre", length = 30, unique = true, nullable = false)
    private String name;

    @Column(name = "celular", length = 10)
    private String phoneNumber;

    @Column(name = "direccion", length = 40)
    private String address;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "persona_empresa",
            joinColumns = @JoinColumn(name = "fk_empresa", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "fk_persona", nullable = false))
    @JsonIgnore
    private List<Person> persons;

    public void addPerson(Person person){
        if (this.persons == null) {
            this.persons = new ArrayList<>();
        }
        this.persons.add(person);
    }

    public Integer getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Integer idCompany) {
        this.idCompany = idCompany;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
