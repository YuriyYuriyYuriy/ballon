package com.balloon_spring_jpa.balloon.dto.mapper;

import com.balloon_spring_jpa.balloon.dto.FoilBalloonDTO;
import com.balloon_spring_jpa.balloon.entity.FoilBalloon;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FoilBalloonMapper {

   // @Mapping(target = "id", ignore = true)
    FoilBalloon mapToFoilBalloonEntity(FoilBalloonDTO foilBalloonDTO);

    List<FoilBalloonDTO> mapToListFoilBalloonDTO(List<FoilBalloon> balloonListEntity);

    FoilBalloonDTO mapToFoilBalloonDTO(FoilBalloon foilBalloonEntity);
}
