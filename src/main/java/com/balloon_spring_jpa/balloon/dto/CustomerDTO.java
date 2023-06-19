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
public class CustomerDTO {

    private UUID id = null;
    private String name;
    private long phone_number;
    private List<OrderDTO> orders;
}
