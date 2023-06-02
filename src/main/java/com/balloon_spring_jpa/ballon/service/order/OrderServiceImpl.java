package com.balloon_spring_jpa.ballon.service.order;

import com.balloon_spring_jpa.ballon.entity.Order;
import com.balloon_spring_jpa.ballon.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository repository;

    @Autowired
    public OrderServiceImpl(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Order> findAll() {
        return repository.findAll();
    }

    @Override
    public Order findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public String delete(int id) {          //??????????????????????????????????????
        repository.deleteById(id);
        return "done";
    }

    @Override
    public Order save(Order order) {
        return repository.save(order);
    }

}
