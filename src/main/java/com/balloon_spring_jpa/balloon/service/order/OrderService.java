package com.balloon_spring_jpa.balloon.service.order;

import com.balloon_spring_jpa.balloon.dto.OrderDTO;

import java.util.List;
import java.util.UUID;


public interface OrderService {

    List<OrderDTO> findAll();

    OrderDTO findById(UUID id);

    void delete(UUID id);

    OrderDTO save(OrderDTO order);

    OrderDTO update(OrderDTO order, UUID id);
}
