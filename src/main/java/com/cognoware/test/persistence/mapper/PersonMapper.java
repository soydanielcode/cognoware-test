package com.cognoware.test.persistence.mapper;

import com.cognoware.test.domain.dto.PersonDTO;
import com.cognoware.test.persistence.entity.Company;
import com.cognoware.test.persistence.entity.Person;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    @Mappings({
            @Mapping(source = "idPerson", target = "idPerson"),
            @Mapping(source = "passport", target = "passport"),
            @Mapping(source = "names", target = "names"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "address", target = "address"),
            @Mapping(source = "phoneNumber", target = "phoneNumber"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "birthdate", target = "birthdate"),
            @Mapping(source = "company", target = "company"),
    })
    PersonDTO toPersonDTO(Person person);
    List<PersonDTO> toPersonDTOs(List<Person> persons);

    @InheritInverseConfiguration
    Person toPerson(PersonDTO personDTO);
}
