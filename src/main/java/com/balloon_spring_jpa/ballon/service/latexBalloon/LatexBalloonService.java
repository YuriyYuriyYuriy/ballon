package com.balloon_spring_jpa.ballon.service.latexBalloon;

import com.balloon_spring_jpa.ballon.entity.LatexBalloon;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface LatexBalloonService {

    List<LatexBalloon> findAll();

    LatexBalloon save(LatexBalloon latexBalloon);

    LatexBalloon update(LatexBalloon latexBalloon);

    LatexBalloon findById(UUID id);

    void delete(UUID id);
}
