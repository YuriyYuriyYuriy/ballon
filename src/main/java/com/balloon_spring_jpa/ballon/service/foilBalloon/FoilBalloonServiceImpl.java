package com.balloon_spring_jpa.ballon.service.foilBalloon;

import com.balloon_spring_jpa.ballon.entity.FoilBalloon;
import com.balloon_spring_jpa.ballon.repository.FoilBalloonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FoilBalloonServiceImpl implements FoilBalloonService {

    private FoilBalloonRepository repository;

    @Autowired
    public FoilBalloonServiceImpl(FoilBalloonRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<FoilBalloon> findAll() {
        return repository.findAll();
    }

    @Override
    public FoilBalloon save(FoilBalloon balloon) {
        return repository.save(balloon);
    }

    @Override
    public FoilBalloon update(FoilBalloon balloon) {
        return repository.save(balloon);
    }

    @Override
    public FoilBalloon findById(UUID id) {
        return repository.findById(id).get();
    }

    @Transactional
    @Override
    public void delete(UUID id) {
        var byId = repository.findById(id).get();
        repository.delete(byId);
    }
}
