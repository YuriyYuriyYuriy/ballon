package com.balloon_spring_jpa.balloon.service.customer;

import com.balloon_spring_jpa.balloon.dto.CustomerDTO;
import com.balloon_spring_jpa.balloon.dto.mapper.CustomerMapper;
import com.balloon_spring_jpa.balloon.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    @Transactional
    @Override
    public List<CustomerDTO> findAll() {
        var allEntities = repository.findAll();
        return mapper.mapToCustomerListDTO(allEntities);
    }

    @Transactional
    @Override
    public List<CustomerDTO> getAllCustomersWithOrders() {
        var allWithOrders = repository.findAllWithOrders();
        return mapper.mapToCustomerListDTO(allWithOrders);
    }

    @Transactional
    @Override
    public CustomerDTO findById(UUID id) {
        var byId = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("no such entity"));
        return mapper.mapToCustomerDTO(byId);
    }

    @Transactional
    @Override
    public CustomerDTO save(CustomerDTO customer) {
        var toEntity = mapper.mapToCustomerEntity(customer);
        var saveEntity = repository.save(toEntity);
        return mapper.mapToCustomerDTO(saveEntity);
    }

    @Transactional
    @Override
    public CustomerDTO update(CustomerDTO customer, UUID id) {
        var byId = repository.findById(id).orElseThrow();
        var toEntity = mapper.mapToCustomerEntity(customer);
        toEntity.setId(id);
        var savingEntity = repository.save(toEntity);
        return mapper.mapToCustomerDTO(savingEntity);
    }

    @Transactional
    @Override
    public void delete(UUID id) {
        var customerId = repository.findById(id).orElseThrow();
        repository.delete(customerId);
    }
}
