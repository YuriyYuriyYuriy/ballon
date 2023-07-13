package com.balloon_spring_jpa.balloon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
        //@MapperScan("com.balloon_spring_jpa.ballon.dto.mapper")
public class BalloonApplication {

    public static void main(String[] args) {
        SpringApplication.run(BalloonApplication.class, args);
//        var context = SpringApplication.run(BalloonApplication.class, args);
//        var customerRepository = context.getBean(CustomerRepository.class);
//        var orderRepository = context.getBean(OrderRepository.class);
//        Customer customer = new Customer();
//        customer.setName("masha");
//        Order order = new Order();
//        order.setAddress("masha addrres");
//        order.setCustomer(customer);
//        customer.setOrders(List.of(order));
//
//
//
//        customerRepository.save(customer);
//       // orderRepository.save(order);

    }

}
