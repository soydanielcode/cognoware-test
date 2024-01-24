package com.cognoware.test.domain.repository;

import com.cognoware.test.domain.dto.PersonDTO;
import com.cognoware.test.persistence.projections.EmployeesSummary;

import java.util.List;
import java.util.Optional;

public interface PersonRepository {
    List<PersonDTO> getAll();
    Optional<PersonDTO> getPerson(int idPerson);
    PersonDTO save(PersonDTO personDTO);
    void delete(int id);
    boolean existId(int id);
    List<EmployeesSummary> findSummary();
}
