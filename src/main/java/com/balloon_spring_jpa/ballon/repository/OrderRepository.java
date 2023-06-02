package com.balloon_spring_jpa.ballon.repository;

import com.balloon_spring_jpa.ballon.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
