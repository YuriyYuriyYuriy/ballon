package com.balloon_spring_jpa.balloon.service.foilBalloon;

import com.balloon_spring_jpa.balloon.dto.FoilBalloonDTO;

import java.util.List;
import java.util.UUID;

public interface FoilBalloonService {

    List<FoilBalloonDTO> findAll();

    FoilBalloonDTO save(FoilBalloonDTO balloon);

    FoilBalloonDTO update(FoilBalloonDTO balloon, UUID id);

    FoilBalloonDTO findById(UUID id);

    void delete(UUID id);
}
