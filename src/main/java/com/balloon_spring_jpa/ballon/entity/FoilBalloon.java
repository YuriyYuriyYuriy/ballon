package com.balloon_spring_jpa.ballon.entity;

import com.balloon_spring_jpa.ballon.balloonEnum.FoilBalloonType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "foil_balloon")
public class FoilBalloon {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "name")
    @Enumerated(EnumType.STRING)  // todo: create humanReadable exception for enumValidation
    private FoilBalloonType name;

    @Column(name = "size")
    private int size;

    @Column(name = "cost")
    private double cost;


    @JsonIgnore
    @ManyToMany(mappedBy = "foilBalloons")
    private List<Order> orders;

}
