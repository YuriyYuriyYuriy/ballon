package com.balloon_spring_jpa.balloon.dto.mapper;

import com.balloon_spring_jpa.balloon.dto.LatexBalloonQuantityInOrderDTO;
import com.balloon_spring_jpa.balloon.entity.LatexBalloonQuantityInOrder;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Named("LatexBalloonQuantityInOrderMapper")
@Mapper(componentModel = "spring")
public interface LatexBalloonQuantityInOrderMapper {

    @Mapping(target = "id", ignore = true)
    LatexBalloonQuantityInOrder mapToQuantityInOrderEntity(LatexBalloonQuantityInOrderDTO quantityInOrder);

    @Named("mapToQuantityInOrderDTOListWithoutOrder")
    @IterableMapping(qualifiedByName = "mapToQuantityInOrderDTOWithoutOrder")
    List<LatexBalloonQuantityInOrderDTO> mapToQuantityInOrderDTOListWithoutOrder(List<LatexBalloonQuantityInOrder> quantityInOrders);

    @Named("mapToQuantityInOrderDTOWithoutOrder")
    @Mapping(target = "order", ignore = true)
    LatexBalloonQuantityInOrderDTO mapToQuantityInOrderDTOWithoutOrder(LatexBalloonQuantityInOrder quantityInOrder);


}
