package com.example.carforum.entity.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountRegisterDto {
    private long id;
    private String userName;
    private CharSequence password;
    private String confirmPassword;
    private int role;
}
