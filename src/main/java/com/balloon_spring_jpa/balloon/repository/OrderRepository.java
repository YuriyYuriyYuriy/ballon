package com.balloon_spring_jpa.balloon.repository;

import com.balloon_spring_jpa.balloon.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {

}
