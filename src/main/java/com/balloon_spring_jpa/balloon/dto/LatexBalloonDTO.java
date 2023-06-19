package com.balloon_spring_jpa.balloon.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LatexBalloonDTO {

    private UUID id = null;
    private int size;
    private BigDecimal cost;
    private int quantity;
    private boolean isGlue;
    private List<OrderDTO> orders;
}
