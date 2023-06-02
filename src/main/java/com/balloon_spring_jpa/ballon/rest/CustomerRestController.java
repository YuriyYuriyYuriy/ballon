package com.balloon_spring_jpa.ballon.rest;

import com.balloon_spring_jpa.ballon.entity.Customer;
import com.balloon_spring_jpa.ballon.service.customer.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    private CustomerServiceImpl service;

    @Autowired
    public CustomerRestController(CustomerServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/customers")
    public List<Customer> findAll() {
        return service.findAll();
    }

    @GetMapping("/customers/orders")
    public List<Customer> findAllWithOrders(){
       return service.getAllCustomersWithOrders();
    }

    @GetMapping("/customers/{id}")
    public Customer findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @DeleteMapping("/customers/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }

    @PostMapping("/customers")
    public Customer save(@RequestBody Customer customer) {
        return service.save(customer);
    }

    @PutMapping("/customers")
    public Customer update(@RequestBody Customer customer) {
        return service.save(customer);
    }
}
