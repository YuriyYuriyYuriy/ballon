package com.balloon_spring_jpa.ballon.service.foilBalloon;

import com.balloon_spring_jpa.ballon.entity.FoilBalloon;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface FoilBalloonService {

    List<FoilBalloon> findAll();

    FoilBalloon save(FoilBalloon balloon);

    FoilBalloon update(FoilBalloon balloon);

    FoilBalloon findById(UUID id);

    void delete(UUID id);

}
