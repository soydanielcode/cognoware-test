package com.cognoware.test.web.controller;

import com.cognoware.test.domain.dto.PersonDTO;
import com.cognoware.test.domain.service.PersonService;
import com.cognoware.test.persistence.projections.EmployeesSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping
    public ResponseEntity<List<PersonDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{idPerson}")
    public ResponseEntity<PersonDTO> getPerson(@PathVariable int idPerson) {

        return service.getPerson(idPerson).map(personDTO -> new ResponseEntity<>(personDTO, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeesSummary>> getEmployees() {
        return ResponseEntity.ok(service.getEmployeesByCompany());
    }

    @PostMapping
    public  ResponseEntity<PersonDTO> add(@RequestBody PersonDTO personDTO) {
        if(personDTO.getIdPerson() == null || !service.existId(personDTO.getIdPerson())){
            return new ResponseEntity<>(service.save(personDTO), HttpStatus.CREATED);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public  ResponseEntity<PersonDTO> update(@RequestBody PersonDTO personDTO) {
        if(personDTO.getIdPerson() != null || service.existId(personDTO.getIdPerson())){
            return new ResponseEntity<>(service.save(personDTO), HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        if (service.existId(id)) {
            service.delete(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
