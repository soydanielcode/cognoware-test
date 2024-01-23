package com.cognoware.test.persistence.mapper;

import com.cognoware.test.domain.dto.CompanyDTO;
import com.cognoware.test.persistence.entity.Company;
import com.cognoware.test.persistence.entity.Person;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    @Mappings({
            @Mapping(source = "idCompany", target = "idCompany"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "phoneNumber", target = "phoneNumber"),
            @Mapping(source = "address", target = "address"),
            @Mapping(source = "persons", target = "persons")})
    CompanyDTO toCompanyDTO(Company company);
    List<CompanyDTO> toCompanyDTOs(List<Company> companies);

    @InheritInverseConfiguration
    Company toCompany(CompanyDTO companyDTO);
}
