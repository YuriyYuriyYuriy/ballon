//package com.balloon_spring_jpa.ballon.dto.mapper;
//
//import com.balloon_spring_jpa.ballon.dto.FoilBalloonDTO;
//import com.balloon_spring_jpa.ballon.entity.FoilBalloon;
//import org.springframework.stereotype.Component;
//
////@Component //спринг создает обект = FoilBalloonMapper balloonMapper = new FoilBalloonMapper();
//public class FoilBalloonMapperWithClass {
//    public FoilBalloon mapToFoilBalloonEntity(FoilBalloonDTO foilBalloonDTO){
//        FoilBalloon foilBalloon = new FoilBalloon(
//                null,
//                foilBalloonDTO.getName(),
//                foilBalloonDTO.getSize(),
//                foilBalloonDTO.getCost(),
//                foilBalloonDTO.getQuantity(),
//                null
//        );
//        return foilBalloon;
//    }
//
//    public FoilBalloonDTO mapToFoilBalloonDTO(FoilBalloon foilBalloonEntity){
//        FoilBalloonDTO newFoilBalloonDTO = new FoilBalloonDTO(
//                foilBalloonEntity.getId(),
//                foilBalloonEntity.getName(),
//                foilBalloonEntity.getSize(),
//                foilBalloonEntity.getCost(),
//                foilBalloonEntity.getQuantity(),
//                foilBalloonEntity.getOrders()
//        );
//        return newFoilBalloonDTO;
//    }
//}
