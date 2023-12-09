package com.wte.wteapi.service;

import com.wte.wteapi.entity.Account;
import com.wte.wteapi.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    public List<Account> getAccount(){
        return accountRepository.findAll();
    }

    public Account createAccount(Account account){
        account.setCreatedAt(LocalDateTime.now());
        return accountRepository.save(account);
    }
}
