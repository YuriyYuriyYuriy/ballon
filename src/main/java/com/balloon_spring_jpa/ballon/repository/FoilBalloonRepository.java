package com.balloon_spring_jpa.ballon.repository;

import com.balloon_spring_jpa.ballon.entity.FoilBalloon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FoilBalloonRepository extends JpaRepository<FoilBalloon, UUID> {
}