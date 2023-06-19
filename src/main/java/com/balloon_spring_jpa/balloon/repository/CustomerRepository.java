package com.balloon_spring_jpa.balloon.repository;

import com.balloon_spring_jpa.balloon.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
 
    @Query("SELECT cust FROM Customer cust JOIN FETCH cust.orders")
    List<Customer> findAllWithOrders();
}
