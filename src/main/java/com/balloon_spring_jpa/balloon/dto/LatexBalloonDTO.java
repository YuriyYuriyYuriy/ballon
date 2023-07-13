package com.balloon_spring_jpa.balloon.dto;

import com.balloon_spring_jpa.balloon.balloonEnum.LatexBalloonType;
import com.balloon_spring_jpa.balloon.entity.LatexBalloonQuantityInOrder;
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

    private UUID id;
    private LatexBalloonType balloonType;
    private int size;
    private BigDecimal cost;
    private int stockBalance;
    private boolean isGlue;
    private List<LatexBalloonQuantityInOrderDTO> latexBalloonQuantityInOrder;
}
