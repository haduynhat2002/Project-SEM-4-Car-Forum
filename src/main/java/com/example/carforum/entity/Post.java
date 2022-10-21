package com.example.carforum.entity;

import com.example.carforum.entity.myenum.UserStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;
    private LocalDateTime date;
    private String image;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="Topic_id", nullable = false)
    private Topic topic;
    @Column(updatable = false, insertable = false)
    private int topic_id;
    private String description;
    @Enumerated(EnumType.ORDINAL)
    private UserStatus status;

}
