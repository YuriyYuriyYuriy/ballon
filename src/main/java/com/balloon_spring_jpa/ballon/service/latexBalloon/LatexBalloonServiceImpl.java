package com.balloon_spring_jpa.ballon.service.latexBalloon;

import com.balloon_spring_jpa.ballon.entity.LatexBalloon;
import com.balloon_spring_jpa.ballon.repository.LatexBalloonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LatexBalloonServiceImpl implements LatexBalloonService{

    private LatexBalloonRepository repository;

    @Autowired
    public LatexBalloonServiceImpl(LatexBalloonRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<LatexBalloon> findAll() {
        return repository.findAll();
    }

    @Override
    public LatexBalloon save(LatexBalloon latexBalloon) {
        return repository.save(latexBalloon);
    }

    @Override
    public LatexBalloon update(LatexBalloon latexBalloon) {
        return repository.save(latexBalloon);
    }

    @Override
    public LatexBalloon findById(UUID id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
