package com.balloon_spring_jpa.balloon.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "foil_balloon_quantity_in_order")
public class FoilBalloonQuantityInOrder {

     @Column(name = "id")
     @Id
     @GeneratedValue//(generator = "UUID")
     private UUID id;

     @Column(name = "quantity")
     private int quantity;

     @ManyToOne(fetch = FetchType.LAZY)
     private FoilBalloon foilBalloon;

     @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
     private Order order;

}
