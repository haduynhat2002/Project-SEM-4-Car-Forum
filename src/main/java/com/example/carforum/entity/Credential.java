package com.example.carforum.entity;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Credential {
    private String accessToken;
    private String refreshToken;
    private long expiredAt;
    private String scope;
}
