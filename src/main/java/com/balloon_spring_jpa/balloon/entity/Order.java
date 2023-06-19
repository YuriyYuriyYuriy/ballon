package com.balloon_spring_jpa.balloon.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "customer_order")
public class Order {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id")
    private UUID id;

    @Column(name = "address")
    private String address;

    @Column(name = "amount")
    private BigDecimal totalPrice;

    @DateTimeFormat
    @Column(name = "data_time")
    private LocalDateTime dateTime = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private List<LatexBalloonQuantityInOrder> latexBalloonQuantityInOrder;

    @OneToMany(mappedBy = "order")
    private List<FoilBalloonQuantityInOrder> foilBalloonQuantityInOrder;



//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//            name = "order_foil_balloons",
//            joinColumns = @JoinColumn(name = "order_id"),
//            inverseJoinColumns = @JoinColumn(name = "foil_balloons_id")
//    )
//    private List<FoilBalloon> foilBalloons;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//            name = "order_latex_balloon",
//            joinColumns = @JoinColumn(name = "order_id"),
//            inverseJoinColumns = @JoinColumn(name = "latex_balloon_id")
//    )
//    private List<LatexBalloon> latexBalloons;
}
