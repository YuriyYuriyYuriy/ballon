package com.balloon_spring_jpa.balloon.dto.mapper;

import com.balloon_spring_jpa.balloon.dto.OrderDTO;
import com.balloon_spring_jpa.balloon.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

   // @Mapping(target = "id", ignore = true)
    Order mapToOrderEntity(OrderDTO orderDTO);

    OrderDTO mapToOrderDTO(Order orderEntity);

    List<OrderDTO> mapToOrderDTOList(List<Order> orderEntities);
}
