package com.cognoware.test.persistence.crud;

import com.cognoware.test.persistence.entity.Person;
import org.springframework.data.repository.ListCrudRepository;

public interface PersonCrudRepository extends ListCrudRepository<Person, Integer> {
}
