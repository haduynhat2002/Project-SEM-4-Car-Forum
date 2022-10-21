package com.example.carforum.entity;

import com.example.carforum.entity.myenum.UserStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="role_id", nullable = false)
    private Role role;
    @Column(updatable = false, insertable = false)
    private int role_id;
    private String founding;
    private String description;
    @Enumerated(EnumType.ORDINAL)
    private UserStatus status;

}
