package com.example.carforum.entity.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountLoginDto {
    private String userName;
    private String password;
}
