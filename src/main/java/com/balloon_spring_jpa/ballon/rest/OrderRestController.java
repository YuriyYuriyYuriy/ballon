package com.balloon_spring_jpa.ballon.rest;

import com.balloon_spring_jpa.ballon.entity.Order;
import com.balloon_spring_jpa.ballon.service.order.OrderService;
import com.balloon_spring_jpa.ballon.service.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderRestController {

    private OrderServiceImpl service;

    @Autowired
    public OrderRestController(OrderServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public List<Order> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Order findById(@PathVariable int id) {
        return service.findById( id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
      //  System.out.println(service.delete(id));
        return service.delete(id);
    }

    @PostMapping
    public Order save(@RequestBody Order order) {
        return service.save(order);
    }

    @PutMapping
    public Order update(@RequestBody Order order) {
        return service.save(order);
    }
}
