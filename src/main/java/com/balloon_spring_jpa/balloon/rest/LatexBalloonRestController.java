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

    private final LatexBalloonServiceImpl service;

    @GetMapping("/balloons")
    public List<LatexBalloonDTO> findAll() {
        return service.findAll();
    }

    @PostMapping("/balloons")
    public LatexBalloonDTO save(@RequestBody LatexBalloonDTO latexBalloonDTO) {
        return service.save(latexBalloonDTO);
    }

    @PutMapping("/balloons/{id}")
    public LatexBalloonDTO update(@RequestBody LatexBalloonDTO latexBalloonDTO, @PathVariable UUID id) {
        return service.update(latexBalloonDTO, id);
    }

    @GetMapping("/balloons/{id}")
    public LatexBalloonDTO findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @DeleteMapping("/balloons/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
