package com.wte.wteapi.dto;

import com.wte.wteapi.entity.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class RecipePostDTO {
    private Long id;
    private String title;
    private String instructions;
    private Integer cookingTime;
    private String difficulty;
    private List<RecipesIngredientsDTO> ingredients;
}
