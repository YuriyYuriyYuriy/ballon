package com.balloon_spring_jpa.balloon.rest;

import com.balloon_spring_jpa.balloon.dto.FoilBalloonDTO;
import com.balloon_spring_jpa.balloon.service.foilBalloon.FoilBalloonServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/foil")
public class FoilBalloonRestController{

    private final FoilBalloonServiceImpl foilBalloonServiceImpl;

    @GetMapping("/balloons")
    public List<FoilBalloonDTO> findAll() {
        return foilBalloonServiceImpl.findAll();
    }

    @PostMapping("/balloons")
    public FoilBalloonDTO save(@RequestBody FoilBalloonDTO foilBalloonDTO) {
        return foilBalloonServiceImpl.save(foilBalloonDTO);
    }

    @PutMapping("/balloons/{id}")
    public FoilBalloonDTO update(@RequestBody FoilBalloonDTO foilBalloonDTO,@PathVariable UUID id) {
        return foilBalloonServiceImpl.update(foilBalloonDTO, id);
    }

    @GetMapping("/balloons/{id}")
    public FoilBalloonDTO findById(@PathVariable UUID id) {
        return foilBalloonServiceImpl.findById(id);
    }

    @DeleteMapping("/balloons/{id}")
    public void delete(@PathVariable UUID id) {
        foilBalloonServiceImpl.delete(id);
    }

}
