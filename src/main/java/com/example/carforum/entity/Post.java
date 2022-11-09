package com.example.carforum.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aspectj.bridge.Message;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
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

    @NotNull(message ="Vui lòng tiêu đề nội dung")
    @Column(length = 125, nullable = false, unique = true)
    private String title;

//    @Min(value = 4, message = "Nội dung không được ít hơn 4 ký tự")
    @NotNull(message ="Vui lòng nhập nội dung")
    private String content;


    @NotNull(message ="Vui lòng nhập ngày tháng")
    private LocalDateTime dateTime;

    private String image;
    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user_id;

}
