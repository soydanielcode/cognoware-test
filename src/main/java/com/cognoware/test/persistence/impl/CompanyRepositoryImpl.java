package com.cognoware.test.persistence.impl;

import com.cognoware.test.domain.dto.CompanyDTO;
import com.cognoware.test.domain.repository.CompanyRepository;
import com.cognoware.test.persistence.crud.CompanyCrudRepository;
import com.cognoware.test.persistence.entity.Company;
import com.cognoware.test.persistence.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompanyRepositoryImpl implements CompanyRepository {
    @Autowired
    private CompanyCrudRepository repository;
    @Autowired
    private CompanyMapper mapper;

    @Override
    public List<CompanyDTO> getAll() {
        return mapper.toCompanyDTOs(repository.findAll());
    }

    @Override
    public Optional<CompanyDTO> getCompany(int idCompany) {
        return repository.findById(idCompany).map(company -> mapper.toCompanyDTO(company));
    }

    @Override
    public CompanyDTO save(CompanyDTO companyDTO) {
        Company company = mapper.toCompany(companyDTO);
        return mapper.toCompanyDTO(repository.save(company));
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
