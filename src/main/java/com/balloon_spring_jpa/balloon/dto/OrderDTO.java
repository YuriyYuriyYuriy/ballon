package com.balloon_spring_jpa.balloon.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class OrderDTO {

    private UUID id = null;
    private String address;
    private LocalDateTime dateTime;
    private CustomerDTO customer;
    private BigDecimal totalPrice;


    private List<FoilBalloonDTO> foilBalloons;


    private List<LatexBalloonDTO> latexBalloons;
}

