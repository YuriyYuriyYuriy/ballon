package com.balloon_spring_jpa.balloon.service.latexBalloon;

import com.balloon_spring_jpa.balloon.dto.LatexBalloonDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface LatexBalloonService {

    List<LatexBalloonDTO> findAll();

    LatexBalloonDTO save(LatexBalloonDTO latexBalloon);

    LatexBalloonDTO update(LatexBalloonDTO latexBalloon, UUID id);

    LatexBalloonDTO findById(UUID id);

    void delete(UUID id);
}
