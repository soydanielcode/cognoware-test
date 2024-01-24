package com.cognoware.test.domain.service;

import com.cognoware.test.domain.dto.CompanyDTO;
import com.cognoware.test.persistence.entity.Person;
import com.cognoware.test.persistence.impl.CompanyRepositoryImpl;
import com.cognoware.test.persistence.impl.PersonRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepositoryImpl repositoryImpl;
    @Autowired
    private PersonRepositoryImpl personRepository;

    public List<CompanyDTO> getAll() {
        return repositoryImpl.getAll();
    }

    public Optional<CompanyDTO> getCompany(int idCompany) {
        return repositoryImpl.getCompany(idCompany);
    }

    public CompanyDTO save(CompanyDTO companyDTO) {
        return repositoryImpl.save(companyDTO);
    }

    public boolean delete(int id) {
        return getCompany(id).map(companyDTO -> {
            repositoryImpl.delete(id);
            return true;
        }).orElse(false);
    }

    public void addPerson(int idCompany, List<Integer> idPerson){
       repositoryImpl.addPerson(idCompany, idPerson);
    }

    public boolean existId(int id){
        return repositoryImpl.existId(id);
    }

}
