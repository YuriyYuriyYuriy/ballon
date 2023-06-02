package com.balloon_spring_jpa.ballon.entity;

import com.balloon_spring_jpa.ballon.balloonEnum.LatexBalloonType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "latex_balloon")
public class LatexBalloon {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private LatexBalloonType name;

    @Column(name = "size")
    private int size;

    @Column(name = "cost")
    private double cost;

    @Column(name = "is_glue")
    private boolean isGlue;


    @JsonIgnore
    @ManyToMany(mappedBy = "latexBalloons")
    private List<Order> orders;
}
