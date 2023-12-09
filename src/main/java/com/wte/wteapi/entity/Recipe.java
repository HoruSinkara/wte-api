package com.wte.wteapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@Table(name = "recipe")
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(columnDefinition = "TEXT")
    private String instructions;
    @Column(name = "cooking_time")
    private LocalDate cookingTime;
    private String difficulty;
}
