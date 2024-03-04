package com.wte.wteapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@Table(name = "account")
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    private String phone;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "is_admin")
    private boolean isAdmin;
    @Lob
    private byte[] image;


}
