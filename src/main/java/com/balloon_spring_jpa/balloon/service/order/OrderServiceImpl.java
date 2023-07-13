package com.balloon_spring_jpa.balloon.service.order;

import com.balloon_spring_jpa.balloon.balloonEnum.OrderStatus;
import com.balloon_spring_jpa.balloon.dto.OrderDTO;
import com.balloon_spring_jpa.balloon.dto.mapper.OrderMapper;
import com.balloon_spring_jpa.balloon.entity.Customer;
import com.balloon_spring_jpa.balloon.entity.FoilBalloonQuantityInOrder;
import com.balloon_spring_jpa.balloon.entity.LatexBalloonQuantityInOrder;
import com.balloon_spring_jpa.balloon.entity.Order;
import com.balloon_spring_jpa.balloon.repository.OrderRepository;
import com.balloon_spring_jpa.balloon.service.foilBalloon.FoilBalloonService;
import com.balloon_spring_jpa.balloon.service.latexBalloon.LatexBalloonService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final FoilBalloonService foilBalloonService;
    private final LatexBalloonService latexBalloonService;

    @Transactional
    @Override
    public List<OrderDTO> findAll() {
        var allEntities = orderRepository.findAll();
        return orderMapper.mapToOrderDTOList(allEntities);
    }

    @Transactional
    @Override
    public OrderDTO findById(UUID id) {
        var orderById = orderRepository.findById(id).orElseThrow();
        return orderMapper.mapToOrderDTO(orderById);
    }

    @Override
    public void delete(UUID id) {
        orderRepository.deleteById(id);
    }

    @Transactional
    @Override
    public OrderDTO update(OrderDTO order, UUID id) { //TODO update price
        orderRepository.findById(id).orElseThrow();
        var toEntity = orderMapper.mapToOrderEntity(order);
        toEntity.setId(id);
        var savingEntity = orderRepository.save(toEntity);
        return orderMapper.mapToOrderDTO(savingEntity);
    }

    @Transactional
    @Override
    public OrderDTO updateStatus(OrderStatus status, UUID id) {
        var orderFromDB = orderRepository.findById(id).orElseThrow();
        var customerFromOrder = orderFromDB.getCustomer();

        if (status.equals(OrderStatus.DONE)) {
            customerFromOrder.setTotalBalance(orderFromDB.getTotalPrice());
        }
        
        return orderMapper.mapToOrderDTO(orderFromDB);
    }

    /**
     * Добавить логику скидки с учетом Сustomer.totalBalabce.
     */

    private void personalCustomerDiscount(UUID id) {
        var orderFromDB = orderRepository.findById(id).orElseThrow();
        var customerFromDB = orderFromDB.getCustomer();
        var customerTotalBalance = customerFromDB.getTotalBalance();

        int caseDiscount = customerTotalBalance.intValue();

        switch (caseDiscount) {
            case 100000 -> {
                // totalPrice.subtract(totalPrice.multiply(new BigDecimal(5)).divide(new BigDecimal(100)));
                var discountFivePercent = caseDiscount - caseDiscount * 0.05;
            }
            case 70000 -> {
                var discountThreePercent = caseDiscount - caseDiscount * 0.03;
            }
            case 50000 -> {
                var discountOnePercent = caseDiscount - caseDiscount * 0.01;
            }
        }

        customerFromDB.setTotalBalance(BigDecimal.valueOf(caseDiscount));
    }


    @Transactional
    @Override
    public OrderDTO save(OrderDTO orderDTO) {
        BigDecimal totalPriceOfOrder = BigDecimal.ZERO;

        if (orderDTO.getLatexBalloonQuantity() != null) {
            var orderSumOfLatex =
                    latexBalloonService.removeFromBalanceAndCountPrice(orderDTO.getLatexBalloonQuantity());
            totalPriceOfOrder = totalPriceOfOrder.add(orderSumOfLatex);
        }

        if (orderDTO.getFoilBalloonQuantity() != null) {
            var orderSumOfFoil =
                    foilBalloonService.removeFromBalanceAndCountPrice(orderDTO.getFoilBalloonQuantity());
            totalPriceOfOrder = totalPriceOfOrder.add(orderSumOfFoil);
        }

        orderDTO.setTotalPrice(totalPriceOfOrder);

        var orderEntity = orderMapper.mapToOrderEntity(orderDTO);

        if (orderEntity.getLatexBalloonQuantity() != null) {
            for (LatexBalloonQuantityInOrder inOrder : orderEntity.getLatexBalloonQuantity()) {
                inOrder.setOrder(orderEntity);
            }
        }

        if (orderEntity.getFoilBalloonQuantity() != null) {
            for (FoilBalloonQuantityInOrder inOrder : orderEntity.getFoilBalloonQuantity()) {
                //  cascade = CascadeType.ALL)  в фоилбфлунах не нужно
//                FoilBalloon detached = inOrder.getFoilBalloon();
//                inOrder.setFoilBalloon(entityManager.merge(detached));
                inOrder.setOrder(orderEntity);
            }
        }

        var savedEntity = orderRepository.save(orderEntity);

        return orderMapper.mapToOrderDTO(savedEntity);
    }
}












