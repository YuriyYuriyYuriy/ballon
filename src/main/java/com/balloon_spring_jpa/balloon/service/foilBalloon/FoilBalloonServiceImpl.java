package com.balloon_spring_jpa.balloon.service.foilBalloon;

import com.balloon_spring_jpa.balloon.dto.FoilBalloonDTO;
import com.balloon_spring_jpa.balloon.dto.mapper.FoilBalloonMapper;
import com.balloon_spring_jpa.balloon.repository.FoilBalloonRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FoilBalloonServiceImpl implements FoilBalloonService {

    private final FoilBalloonRepository repository;
    private final FoilBalloonMapper foilBalloonMapper;

//    @Autowired
//    public FoilBalloonServiceImpl(FoilBalloonRepository repository, FoilBalloonMapper foilBalloonMapper) {
//        this.repository = repository;
//        this.foilBalloonMapper = foilBalloonMapper;
//    }

    @Transactional
    @Override
    public FoilBalloonDTO save(FoilBalloonDTO balloon) {
        var toEntity = foilBalloonMapper.mapToFoilBalloonEntity(balloon);
        var saveEntity = repository.save(toEntity);
        return foilBalloonMapper.mapToFoilBalloonDTO(saveEntity);
    }

    @Transactional
    @Override
    public FoilBalloonDTO update(FoilBalloonDTO balloon, UUID id) {
       repository.findById(id).orElseThrow();
       var toEntity = foilBalloonMapper.mapToFoilBalloonEntity(balloon);
       toEntity.setId(id);
       var savingEntity = repository.save(toEntity);
       return foilBalloonMapper.mapToFoilBalloonDTO(savingEntity);
    }

    @Override
    public List<FoilBalloonDTO> findAll() {
        var entitiesFromDB = repository.findAll();
        return foilBalloonMapper.mapToListFoilBalloonDTO(entitiesFromDB);
    }

    @Transactional
    @Override
    public FoilBalloonDTO findById(UUID id) {
        var entityById = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("no such entity"));
        return foilBalloonMapper.mapToFoilBalloonDTO(entityById);
    }

    @Transactional
    @Override
    public void delete(UUID id) {
        var byId = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("no such entity"));
        repository.delete(byId);
    }
}
