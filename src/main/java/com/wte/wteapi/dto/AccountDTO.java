package com.wte.wteapi.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class AccountDTO {
    private Long id;
    private String name;
    private String password;
    private String phone;
    private LocalDateTime createdAt;
    @Column(name = "isAdmin")
    private boolean isAdmin;
    private byte[] image;
}
