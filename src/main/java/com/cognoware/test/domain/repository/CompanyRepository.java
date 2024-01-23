package com.cognoware.test.domain.repository;

import com.cognoware.test.domain.dto.CompanyDTO;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository {
    List<CompanyDTO> getAll();
    Optional<CompanyDTO> getCompany(int idCompany);
    CompanyDTO save(CompanyDTO companyDTO);
    void delete(int id);

    boolean existId (int id);
}
