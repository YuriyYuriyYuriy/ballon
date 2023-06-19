package com.balloon_spring_jpa.balloon.rest;

import com.balloon_spring_jpa.balloon.dto.OrderDTO;
import com.balloon_spring_jpa.balloon.service.order.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class OrderRestController {

    private final OrderServiceImpl service;

    @GetMapping("/orders")
    public List<OrderDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/orders/{id}")
    public OrderDTO findById(@PathVariable UUID id) {
        return service.findById( id);
    }

    @DeleteMapping("/orders{id}")
    public void delete(@PathVariable UUID id) {
         service.delete(id);
    }

    @PostMapping("/orders")
    public OrderDTO save(@RequestBody OrderDTO order) {
        return service.save(order);
    }

    @PutMapping("/orders/{id}")
    public OrderDTO update(@RequestBody OrderDTO order, @PathVariable UUID id) {
        return service.update(order, id);
    }
}
