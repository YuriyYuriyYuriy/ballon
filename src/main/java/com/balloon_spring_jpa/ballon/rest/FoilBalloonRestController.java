package com.balloon_spring_jpa.ballon.rest;

import com.balloon_spring_jpa.ballon.entity.FoilBalloon;
import com.balloon_spring_jpa.ballon.service.foilBalloon.FoilBalloonService;
import com.balloon_spring_jpa.ballon.service.foilBalloon.FoilBalloonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/foil")
public class FoilBalloonRestController{

    private FoilBalloonService repository;

    @Autowired
    public FoilBalloonRestController(FoilBalloonServiceImpl repository) {
        this.repository = repository;
    }

    @GetMapping("/balloons")
    public List<FoilBalloon> findAll() {
        return repository.findAll();
    }

    @PostMapping("/balloons")
    public FoilBalloon save(@RequestBody FoilBalloon latexBalloon) {
        return repository.save(latexBalloon);
    }

    @PutMapping("/balloons")
    public FoilBalloon update(@RequestBody FoilBalloon latexBalloon) {
        return repository.save(latexBalloon);
    }

    @GetMapping("/balloons/{id}")
    public FoilBalloon findById(@PathVariable UUID id) {
        return repository.findById(id);
    }

    @DeleteMapping("/balloons/{id}")
    public void delete(@PathVariable UUID id) {
        repository.delete(id);
    }

}
