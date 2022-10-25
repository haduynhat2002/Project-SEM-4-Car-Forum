package com.example.carforum.service;


import com.example.carforum.entity.Account;
import com.example.carforum.entity.Credential;
import com.example.carforum.entity.dto.AccountLoginDto;
import com.example.carforum.entity.dto.AccountRegisterDto;
import com.example.carforum.repository.AccountRepository;
import com.example.carforum.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AccountService implements UserDetailsService {
    final AccountRepository accountRepository;
    final PasswordEncoder passwordEncoder;

    public AccountRegisterDto register(AccountRegisterDto accountRegisterDto) {
        Optional<Account> optionalAccount = accountRepository.findAccountByUserName(accountRegisterDto.getUserName());
        if (optionalAccount.isPresent()) {
            return null;
        }
        Account account = Account.builder()
                .userName(accountRegisterDto.getUserName())
                .passwordHash(passwordEncoder.encode(accountRegisterDto.getPassword()))
                .role(accountRegisterDto.getRole())
                .build();
        accountRepository.save(account);
        accountRegisterDto.setId(account.getId());
        return accountRegisterDto;
    }

    public Credential login(AccountLoginDto accountLoginDto) {
        Optional<Account> optionalAccount = accountRepository.findAccountByUserName(accountLoginDto.getUserName());
        if (!optionalAccount.isPresent()){
            throw new UsernameNotFoundException("User is not found");
        }
        Account account = optionalAccount.get();
        boolean isMatch = passwordEncoder.matches(accountLoginDto.getPassword(), account.getPasswordHash());
        if (isMatch){
            int expiredAfterday = 7;
            String accessToken = JwtUtil.generateTokenByAccount(account, 24 * 60 * 60 * 1000);
            String refreshToken = JwtUtil.generateTokenByAccount (account, 14 * 24 * 60 * 60 * 1000);
            Credential credential = new Credential();
            credential.setAccessToken(accessToken);
            credential.setRefreshToken(refreshToken);
            credential.setExpiredAt(expiredAfterday);
            credential.setScope("bacis_information");
            return credential;
        }else {
            throw new UsernameNotFoundException("Password is not match");
        }
    }

    public void getInformation() {

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Optional<Account> optionalAccount = accountRepository.findAccountByUserName(username);
        if (!optionalAccount.isPresent()){
            throw new UsernameNotFoundException("User name is not found");
        }
        Account account = optionalAccount.get();
        List<GrantedAuthority> authorities = new ArrayList<>();
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(account.getRole() == 1 ? "ADMIN" : "USER");
        authorities.add(simpleGrantedAuthority);
        return new User(account.getUserName(), account.getPasswordHash(), authorities);
    }
}
