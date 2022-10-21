package com.example.carforum.entity;

import com.example.carforum.entity.myenum.PriceCarStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "pricecar")
public class PriceCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="category_id", nullable = false)
    private CategoryCar categoryCar;
    @Column(updatable = false, insertable = false)
    private String name;
    private String listed_price;
    private String rolling_price;
    @Enumerated(EnumType.ORDINAL)
    private PriceCarStatus status;
}
