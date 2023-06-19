package com.balloon_spring_jpa.balloon.dto.mapper;

import com.balloon_spring_jpa.balloon.dto.LatexBalloonDTO;
import com.balloon_spring_jpa.balloon.entity.LatexBalloon;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LatexBalloonMapper {

    // @Mapping(target = "id", ignore = true)
    LatexBalloon mapToLatexBalloonEntity(LatexBalloonDTO latexBalloonDTO);

    LatexBalloonDTO mapToLatexBalloonDTO(LatexBalloon latexBalloonEntity);

    List<LatexBalloonDTO> mapToLatexBalloonListDTO(List<LatexBalloon> latexBalloonEntities);
}
