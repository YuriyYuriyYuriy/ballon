package com.balloon_spring_jpa.ballon.service.customer;

import com.balloon_spring_jpa.ballon.entity.Customer;
import com.balloon_spring_jpa.ballon.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository repository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public Customer findById(UUID id) {
        return repository.findById(id).get();
    }

    @Override
    public Customer save(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomersWithOrders() {
        return repository.findAllWithOrders();
    }

    @Transactional
    @Override
    public void delete(UUID id) {
        var customerId = repository.findById(id);
        if (customerId.isPresent()) repository.delete(customerId.get());
        else System.out.println("no such id - " + id);
    }
}
