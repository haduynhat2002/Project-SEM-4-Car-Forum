package com.example.carforum.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Vui lòng nhập tên")
    private String name;

    private String image;

    @NotEmpty(message = "Vui lòng nhập mô tả")
    private String description;
}
