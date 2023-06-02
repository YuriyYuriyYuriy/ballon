package com.balloon_spring_jpa.ballon.repository;

import com.balloon_spring_jpa.ballon.entity.LatexBalloon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LatexBalloonRepository extends JpaRepository<LatexBalloon, UUID> {
}
