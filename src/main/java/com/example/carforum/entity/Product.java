package com.example.carforum.entity;


import com.example.carforum.entity.myenum.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String retailprice;
    private String origin;
    private String rangeofvehicle;
    private int numberofseats;
    private int gear;
    private ProductStatus productStatus;
    @ManyToOne
    @JoinColumn(name = "dealer_id")
    private Dealer dealer;
}
