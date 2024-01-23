package com.cognoware.test.persistence.impl;

import com.cognoware.test.domain.dto.PersonDTO;
import com.cognoware.test.domain.repository.PersonRepository;
import com.cognoware.test.persistence.crud.PersonCrudRepository;
import com.cognoware.test.persistence.entity.Person;
import com.cognoware.test.persistence.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PersonRepositoryImpl implements PersonRepository {
    @Autowired
    private PersonCrudRepository repository;
    @Autowired
    private PersonMapper mapper;

    @Override
    public List<PersonDTO> getAll() {
        return mapper.toPersonDTOs(repository.findAll());
    }

    @Override
    public Optional<PersonDTO> getPerson(int idPerson) {
        return repository.findById(idPerson).map(person -> mapper.toPersonDTO(person));
    }

    @Override
    public PersonDTO save(PersonDTO personDTO) {
        Person person = mapper.toPerson(personDTO);
        return mapper.toPersonDTO(repository.save(person));
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public boolean existId(int id) {
        return repository.existsById(id);
    }
}
