package com.balloon_spring_jpa.balloon.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FoilBalloonQuantityInOrderDTO {

    private UUID id;
    private int quantity;
    private FoilBalloonDTO foilBalloon;
    private OrderDTO order;
}
