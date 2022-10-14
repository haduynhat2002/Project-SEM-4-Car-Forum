package com.example.carforum.entity;

import com.example.carforum.entity.myenum.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
    private String username;
    private String password;
    private String email;
    private String phone;
    private String avatar;
    private Date birthday;
    private int gender;
    @ManyToOne
    @JoinColumn(name="role_id", nullable = false)
    private Role role;
    @Column(updatable = false, insertable = false)
    private int role_id;
    @Enumerated(EnumType.ORDINAL)
    private UserStatus status;

}
