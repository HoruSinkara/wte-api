package com.wte.wteapi.dto.converters;

import com.wte.wteapi.dto.AccountDTO;
import com.wte.wteapi.entity.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountConverter {
    public static AccountDTO convertToDTO (Account account){
        return AccountDTO.builder()
                .id(account.getId())
                .name(account.getName())
                .password(account.getPassword())
                .phone(account.getPhone())
                .createdAt(account.getCreatedAt())
                .isAdmin(account.isAdmin())
                .image(account.getImage())
                .build();
    }
    public static List<AccountDTO> convertToListDTO(List<Account> accountList){
        List<AccountDTO> accountDTOList = new ArrayList<>();
        for(Account account: accountList){
            accountDTOList.add(convertToDTO(account));
        }
        return accountDTOList;
    }
    public static Account convertToEntity(AccountDTO accountDTO){
        return Account.builder()
                .id(accountDTO.getId())
                .name(accountDTO.getName())
                .phone(accountDTO.getPhone())
                .password(accountDTO.getPassword())
                .createdAt(accountDTO.getCreatedAt())
                .isAdmin(accountDTO.isAdmin())
                .image(accountDTO.getImage()!=null? accountDTO.getImage() : null)
                .build();
    }
}
