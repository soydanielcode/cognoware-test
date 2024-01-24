package com.cognoware.test.persistence.crud;

import com.cognoware.test.persistence.entity.Person;
import com.cognoware.test.persistence.projections.EmployeesSummary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface PersonCrudRepository extends ListCrudRepository<Person, Integer> {
    @Query(value =
            "select concat(p.nombres, ' ' , p.apellidos) as personName, e.nombre as companyName  " +
                    "from empresa e " +
                    "inner join persona_empresa pe " +
                    "on pe.id_empresa = e.id_empresa " +
                    "inner join persona p " +
                    "on p.id_persona = pe.id_persona " +
                    "order by p.nombres ", nativeQuery = true)
    List<EmployeesSummary> findSummary();
}
