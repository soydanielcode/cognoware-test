package com.cognoware.test.web.controller;

import com.cognoware.test.domain.dto.CompanyDTO;
import com.cognoware.test.domain.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    @Autowired
    private CompanyService service;

    @GetMapping
    public ResponseEntity<List<CompanyDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{idCompany}")
    public ResponseEntity<CompanyDTO> getCompany(@PathVariable int idCompany) {

        return service.getCompany(idCompany).map(companyDTO -> new ResponseEntity<>(companyDTO, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public  ResponseEntity<CompanyDTO> add(@RequestBody CompanyDTO companyDTO) {
        if(companyDTO.getIdCompany() == null || !service.existId(companyDTO.getIdCompany())){
            return new ResponseEntity<>(service.save(companyDTO), HttpStatus.CREATED);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public  ResponseEntity<CompanyDTO> update(@RequestBody CompanyDTO companyDTO) {
        if(companyDTO.getIdCompany() != null || service.existId(companyDTO.getIdCompany())){
            return new ResponseEntity<>(service.save(companyDTO), HttpStatus.OK);
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
