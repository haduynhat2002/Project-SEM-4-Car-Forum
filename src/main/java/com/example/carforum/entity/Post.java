package com.example.carforum.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 255, nullable = false, unique = true)
    private String title;
    private String content;
    private LocalDateTime dateTime;
    private String image;
    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

}
