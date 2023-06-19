package com.balloon_spring_jpa.balloon.service.latexBalloon;

import com.balloon_spring_jpa.balloon.dto.LatexBalloonDTO;
import com.balloon_spring_jpa.balloon.dto.mapper.LatexBalloonMapper;
import com.balloon_spring_jpa.balloon.repository.LatexBalloonRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LatexBalloonServiceImpl implements LatexBalloonService {

    private final LatexBalloonRepository repository;
    private final LatexBalloonMapper mapper;

    @Override
    @Transactional
    public List<LatexBalloonDTO> findAll() {
        var entitiesFromDB = repository.findAll();
        return mapper.mapToLatexBalloonListDTO(entitiesFromDB);
    }

    @Override
    @Transactional
    public LatexBalloonDTO save(LatexBalloonDTO latexBalloonDTO) {

        var toEntity = mapper.mapToLatexBalloonEntity(latexBalloonDTO);
        var saveEntity = repository.save(toEntity);
        return mapper.mapToLatexBalloonDTO(saveEntity);
    }

    @Override
    @Transactional
    public LatexBalloonDTO update(LatexBalloonDTO latexBalloonDTO, UUID id) {
        repository.findById(id)
                .orElseThrow(() -> new RuntimeException("no such entity"));
        var entity = mapper.mapToLatexBalloonEntity(latexBalloonDTO);

        entity.setId(id);

        var saveEntity = repository.save(entity);
        return mapper.mapToLatexBalloonDTO(saveEntity);
    }

    @Override
    @Transactional
    public LatexBalloonDTO findById(UUID id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("no such entity"));
        return mapper.mapToLatexBalloonDTO(entity);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
