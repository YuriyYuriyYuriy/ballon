package com.balloon_spring_jpa.balloon.rest;

import com.balloon_spring_jpa.balloon.dto.LatexBalloonDTO;
import com.balloon_spring_jpa.balloon.service.latexBalloon.LatexBalloonServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/latex")
public class LatexBalloonRestController {

    private final LatexBalloonServiceImpl latexBalloonService;

    @GetMapping("/balloons")
    public List<LatexBalloonDTO> findAll() {
        return latexBalloonService.findAll();
    }

    @PostMapping("/balloons")
    public LatexBalloonDTO save(@RequestBody LatexBalloonDTO latexBalloon) {
        return latexBalloonService.save(latexBalloon);
    }

    @PutMapping("/balloons/{id}")
    public LatexBalloonDTO update(@RequestBody LatexBalloonDTO latexBalloon, @PathVariable UUID id) {
        return latexBalloonService.update(latexBalloon, id);
    }

    @GetMapping("/balloons/{id}")
    public LatexBalloonDTO findById(@PathVariable UUID id) {
        return latexBalloonService.findById(id);
    }

    @DeleteMapping("/balloons/{id}")
    public void delete(@PathVariable UUID id) {
        latexBalloonService.delete(id);
    }
}
