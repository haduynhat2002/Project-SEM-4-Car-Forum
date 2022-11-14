package com.example.carforum.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dealers")
public class Dealer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Vui lòng nhập tên")
    private String name;
    @NotEmpty(message = "Vui lòng nhập địa chỉ")
    private String adress;
    @NotEmpty(message = "Vui lòng nhập số điện thoại")
    private String hotline;
    private String datetime;
    @NotEmpty(message = "Vui lòng nhập mô tả")
    private String description;
    private String image;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
