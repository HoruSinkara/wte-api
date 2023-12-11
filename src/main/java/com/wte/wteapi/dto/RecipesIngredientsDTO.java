package com.wte.wteapi.dto;

import com.wte.wteapi.entity.Ingredient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class RecipesIngredientsDTO {
    private Integer id;
    private String name;
    private String quantity;
}
