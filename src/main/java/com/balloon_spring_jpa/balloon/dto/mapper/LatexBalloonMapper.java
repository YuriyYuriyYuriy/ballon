package com.balloon_spring_jpa.balloon.dto.mapper;

import com.balloon_spring_jpa.balloon.dto.LatexBalloonDTO;
import com.balloon_spring_jpa.balloon.entity.LatexBalloon;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Named("LatexBalloonMapper")
@Mapper(componentModel = "spring", uses = {LatexBalloonMapper.class, LatexBalloonQuantityInOrderMapper.class})
public interface LatexBalloonMapper {

    @Mapping(target = "id", ignore = true)
    LatexBalloon mapToLatexBalloonEntity(LatexBalloonDTO latexBalloon);


    // НАЧАЛО РЕКУРСИИ
    @Named("mapToLatexBalloonDTOWithoutLatexQuantity")
    @Mapping(target = "latexBalloonQuantityInOrder", ignore = true)
    LatexBalloonDTO mapToLatexBalloonDTOWithoutLatexQuantity(LatexBalloon latexBalloonEntity);

    @Named("mapToLatexBalloonListDTOWithoutLatexQuantity")
    @IterableMapping(qualifiedByName = "mapToLatexBalloonDTOWithoutLatexQuantity")
    List<LatexBalloonDTO> mapToLatexBalloonListDTOWithoutLatexQuantity(List<LatexBalloon> latexBalloonEntities);



    @Mapping(target = "latexBalloonQuantityInOrder",
            qualifiedByName = {"LatexBalloonMapper", "mapToLatexBalloonListDTOWithoutLatexQuantity"})
    LatexBalloonDTO mapToLatexBalloonDTO(LatexBalloon latexBalloonEntity);

    List<LatexBalloonDTO> mapToLatexBalloonListDTO(List<LatexBalloon> latexBalloonEntities);

    List<LatexBalloon> mapToLatexBalloonListEntity(List<LatexBalloonDTO> latexBalloons);











//    @Mapping(target = "id" , ignore = true)
//    @Mapping(target = "balloonType", source = "from.balloonType")
//    @Mapping(target = "size" , source = "from.size")
//    @Mapping(target = "cost" , source = "from.cost")
//    @Mapping(target = "stockBalance" , source = "from.stockBalance")
//    @Mapping(target = "glue" , source = "from.glue")
//    @Mapping(target = "latexBalloonQuantityInOrder" , source = "from.latexBalloonQuantityInOrder")
//    LatexBalloon mapToExistDTO(LatexBalloon from, LatexBalloonDTO to);

    //  public default void mapToExistDTO(LatexBalloon from, LatexBalloonDTO to) {
//        to.setStockBalance(from.getStockBalance());
//        to.setCost(from.getCost());
//        to.setSize(from.getSize());
//        to.setGlue(from.isGlue());
//        to.setOrders(mapper.mapToQuantityInOrderDTOList(from.getOrders()));
    // }
}
