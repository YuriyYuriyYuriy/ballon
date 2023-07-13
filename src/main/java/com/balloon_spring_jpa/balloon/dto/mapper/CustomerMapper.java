package com.balloon_spring_jpa.balloon.dto.mapper;

import com.balloon_spring_jpa.balloon.dto.CustomerDTO;
import com.balloon_spring_jpa.balloon.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    Customer mapToCustomerEntity(CustomerDTO customer);

    CustomerDTO mapToCustomerDTO(Customer customerEntity);

    List<CustomerDTO> mapToCustomerListDTO(List<Customer> customerList);
}
