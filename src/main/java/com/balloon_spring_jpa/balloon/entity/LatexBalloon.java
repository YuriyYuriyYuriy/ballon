package com.balloon_spring_jpa.balloon.entity;

import com.balloon_spring_jpa.balloon.balloonEnum.LatexBalloonType;
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
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "latex_balloon")
public class LatexBalloon {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private LatexBalloonType name;

    @Column(name = "size")
    private int size;

    @Column(name = "cost")
    private BigDecimal cost;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "is_glue")
    private boolean isGlue;

    @OneToMany(mappedBy = "latexBalloon")
    private List<LatexBalloonQuantityInOrder> latexBalloonQuantityInOrder;

//    @JsonIgnore
//    @ManyToMany(mappedBy = "latexBalloons")
//    private List<Order> orders;
}
