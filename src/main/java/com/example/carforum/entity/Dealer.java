package com.example.carforum.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
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
    private String name;
    private String adress;
    private Number hotline;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datetime;
    private String description;
    private String image;
//    @ManyToOne
//    @JoinColumn(name = "topic_id")
//    private Topic topic;
}
