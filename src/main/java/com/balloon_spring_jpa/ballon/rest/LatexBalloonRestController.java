package com.balloon_spring_jpa.ballon.rest;

import com.balloon_spring_jpa.ballon.entity.LatexBalloon;
import com.balloon_spring_jpa.ballon.service.latexBalloon.LatexBalloonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/latex")
public class LatexBalloonRestController {

    private LatexBalloonServiceImpl service;

    @Autowired
    public LatexBalloonRestController(LatexBalloonServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/balloons")
    public List<LatexBalloon> findAll() {
        return service.findAll();
    }

    @PostMapping("/balloons")
    public LatexBalloon save(@RequestBody LatexBalloon latexBalloon) {
        return service.save(latexBalloon);
    }

    @PutMapping("/balloons")
    public LatexBalloon update(@RequestBody LatexBalloon latexBalloon) {
        return service.save(latexBalloon);
    }

    @GetMapping("/balloons/{id}")
    public LatexBalloon findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @DeleteMapping("/balloons/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
