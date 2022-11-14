package com.example.carforum.entity;

import com.example.carforum.entity.myenum.CategoryCarStatus;
import com.example.carforum.entity.myenum.PriceCarStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "categorycar")
public class CategoryCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Vui lòng nhập tên")
    private String name;
    private String image;
//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name="user_id", nullable = false)
//    private User user_id;
    @Column(updatable = false, insertable = false)
    private CategoryCarStatus status;
}
