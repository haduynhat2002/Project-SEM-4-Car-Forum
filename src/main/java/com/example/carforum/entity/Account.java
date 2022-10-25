package com.example.carforum.entity;

import com.example.carforum.entity.myenum.AccountStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userName;
    private String email;
    private String phone;
    private LocalDateTime birthday;
    private String address;
    private int gender;
    private String avatar;
    private String password;
    private String passwordHash;
    private int role;
    private AccountStatus status;
}
