package com.balloon_spring_jpa.balloon.entity;

import com.balloon_spring_jpa.balloon.balloonEnum.FoilBalloonType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
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
    @GeneratedValue(generator = "UUID")
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private FoilBalloonType name;

    @Column(name = "size")
    private int size;

    @Column(name = "cost")
    private BigDecimal cost;

    @Column(name = "quantity")
    private int quantity;

    @JsonIgnore
   // @ManyToMany(mappedBy = "foilBalloons")
    @OneToMany(mappedBy = "foilBalloon", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<FoilBalloonQuantityInOrder> foilBalloonQuantityInOrder;
}

