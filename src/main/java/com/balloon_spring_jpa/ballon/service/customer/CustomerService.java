package com.balloon_spring_jpa.ballon.service.customer;

import com.balloon_spring_jpa.ballon.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public interface CustomerService {

    List<Customer> findAll();

    Customer findById(UUID id);

    void delete(UUID id);

    Customer save(Customer customer);

    Customer update(Customer customer);

    List<Customer> getAllCustomersWithOrders();
}
