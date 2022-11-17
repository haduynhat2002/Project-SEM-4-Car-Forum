package com.example.carforum.entity;

import com.example.carforum.entity.myenum.CarReivewStatus;
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
@Table(name = "carreview")
public class CarReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String content;
    private String image;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="category_id", nullable = false)
    private CategoryCar categoryCar;
    @Enumerated(EnumType.ORDINAL)
    private CarReivewStatus status;}
