package com.balloon_spring_jpa.balloon.dto;

import com.balloon_spring_jpa.balloon.balloonEnum.FoilBalloonType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class FoilBalloonDTO {

    private UUID id = null;
    private FoilBalloonType name;
    private int size;
    private double cost;
    private int quantity;
    private List<OrderDTO> orders;

}
