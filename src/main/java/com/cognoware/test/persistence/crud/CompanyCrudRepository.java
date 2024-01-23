package com.cognoware.test.persistence.crud;

import com.cognoware.test.persistence.entity.Company;
import org.springframework.data.repository.ListCrudRepository;

public interface CompanyCrudRepository extends ListCrudRepository<Company, Integer> {
}
