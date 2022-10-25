package com.example.carforum.util;

import com.example.carforum.entity.Account;
import org.junit.jupiter.api.Test;

class JwtUtilTest {
    @Test
    public void testGenerateToken() {
//        String accceptToken = JwtUtil.generateToken("12312312", "USER", "T2009M1", 7);
//        System.out.println(accceptToken);
//        DecodedJWT decodedJWT = JwtUtil.getVerifier().verify(accceptToken);
//        System.out.println(decodedJWT.getSubject());
//        System.out.println(decodedJWT.getIssuer());
//        System.out.println(decodedJWT.getExpiresAt());

        Account account = Account.builder()
                .id(System.currentTimeMillis())
                .role(1)
                .userName("admin1")
                .passwordHash("1234567")
                .build();
        String accessToken = JwtUtil.generateTokenByAccount(account, 15 * 24 * 60 * 60 * 1000);
        System.out.println(accessToken);

        Account account1 = Account.builder()
                .id(System.currentTimeMillis())
                .role(2)
                .userName("user2")
                .passwordHash("1234567")
                .build();
        String accessToken1 = JwtUtil.generateTokenByAccount(account1, 15 * 24 * 60 * 60 * 1000);
        System.out.println(accessToken1);




//        Account account = Account.builder()
//                .id(System.currentTimeMillis())
//                .role(1)
//                .username("DungNguyen123")
//                .passwordHash("xyz")
//                .build();
//        String accceptTokenAccount = JwtUtil.generateToken("")
    }

}
