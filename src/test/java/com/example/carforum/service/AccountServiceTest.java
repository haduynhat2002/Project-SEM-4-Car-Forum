package com.example.carforum.service;

import com.example.carforum.entity.Credential;
import com.example.carforum.entity.dto.AccountLoginDto;
import com.example.carforum.entity.dto.AccountRegisterDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class AccountServiceTest {
    @Autowired
    AccountService accountService;
    @Test

    void register(){
        AccountRegisterDto accountRegisterDto = new AccountRegisterDto();
        accountRegisterDto.setUserName("TienDungg");
        accountRegisterDto.setPassword("1234566");
        accountRegisterDto.setRole(2);
        AccountRegisterDto afterCreate = accountService.register(accountRegisterDto);
        System.out.println(afterCreate);
    }

    @Test
    void login(){
        AccountLoginDto accountLoginDto = new AccountLoginDto();
        accountLoginDto.setUserName("TienDung");
        accountLoginDto.setPassword("123456");
        Credential credential = new Credential();
        System.out.println(credential.toString());
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
//        Optional<Account> optionalAccount = accountRepository.findAccountByUsername(username);
//        if (!optionalAccount.isPresent()){
//            throw new UsernameNotFoundException("User name is not found");
//        }
//        Account account = optionalAccount.get();
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(account.getRole() == 1 ? "ADMIN" : "USER");
//        authorities.add(simpleGrantedAuthority);
//        return new User(account.getUsername(), account.getPasswordHash(), authorities);
//    }

}
