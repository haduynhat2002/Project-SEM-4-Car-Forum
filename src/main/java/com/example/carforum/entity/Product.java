package com.example.carforum.entity;


import com.example.carforum.entity.myenum.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

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
    @NotEmpty(message = "Vui lòng nhập tên")
    private String name;
    @NotEmpty(message = "Vui lòng nhập giá")
    private String retailprice;
    @NotEmpty(message = "Vui lòng nhập xuất xứ")
    private String origin;
    @NotEmpty(message = "Vui lòng nhập loại xe")
    private String rangeofvehicle;
    @NotEmpty(message = "Vui lòng nhập số chỗ")
    private String numberofseats;
    @NotEmpty(message = "Vui lòng nhập hộp số")
    private String gear;
    private ProductStatus productStatus;
    @ManyToOne
    @JoinColumn(name = "dealer_id")
    private Dealer dealer;
}
