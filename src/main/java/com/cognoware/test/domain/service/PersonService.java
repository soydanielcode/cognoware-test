package com.cognoware.test.domain.service;

import com.cognoware.test.domain.dto.PersonDTO;
import com.cognoware.test.persistence.impl.PersonRepositoryImpl;
import com.cognoware.test.persistence.projections.EmployeesSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepositoryImpl repositoryImpl;

    public List<PersonDTO> getAll() {
        return repositoryImpl.getAll();
    }

    public Optional<PersonDTO> getPerson(int idPerson) {
        return repositoryImpl.getPerson(idPerson);
    }

    public PersonDTO save(PersonDTO personDTO) {
        return repositoryImpl.save(personDTO);
    }

    public boolean delete(int id) {
        return getPerson(id).map(personDTO -> {
            repositoryImpl.delete(id);
            return true;
        }).orElse(false);
    }

    public boolean existId(int id){
       return repositoryImpl.existId(id);
    }

    public List<EmployeesSummary> getEmployeesByCompany(){
        return repositoryImpl.findSummary();
    }
}
