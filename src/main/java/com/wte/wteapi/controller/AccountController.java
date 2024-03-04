package com.wte.wteapi.controller;

import com.wte.wteapi.dto.AccountDTO;
import com.wte.wteapi.dto.converters.AccountConverter;
import com.wte.wteapi.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;


    @GetMapping
    public ResponseEntity<List<AccountDTO>>  getAccount(){
        return new ResponseEntity<>(AccountConverter.convertToListDTO(accountService.getAccount()), HttpStatus.OK);
    }



    @PostMapping
    public ResponseEntity<AccountDTO> createAccount(@RequestBody AccountDTO accountDTO){
        return new ResponseEntity<>(AccountConverter.convertToDTO(accountService.createAccount(AccountConverter.convertToEntity(accountDTO))), HttpStatus.CREATED);
    }
}
