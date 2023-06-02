package com.balloon_spring_jpa.ballon.service.order;

import com.balloon_spring_jpa.ballon.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    List<Order> findAll();

    Order findById(int id);

    String delete(int id);

    Order save(Order order);
}
