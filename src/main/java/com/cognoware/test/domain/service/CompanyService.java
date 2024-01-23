package com.cognoware.test.domain.service;

import com.cognoware.test.domain.dto.CompanyDTO;
import com.cognoware.test.persistence.impl.CompanyRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepositoryImpl repositoryImpl;

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

    public boolean existId(int id){
        return repositoryImpl.existId(id);
    }

}
