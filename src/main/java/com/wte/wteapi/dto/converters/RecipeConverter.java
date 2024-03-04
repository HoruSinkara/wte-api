package com.wte.wteapi.dto.converters;

import com.wte.wteapi.dto.RecipeGetDTO;
import com.wte.wteapi.dto.RecipePostDTO;
import com.wte.wteapi.entity.Recipe;
import com.wte.wteapi.entity.RecipesIngredients;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RecipeConverter {
    public static RecipeGetDTO convertToDTO(Recipe recipe){
        return RecipeGetDTO.builder()
                .id(recipe.getId())
                .title(recipe.getTitle())
                .instructions(recipe.getInstructions())
                .ingredients(RecipesIngredientsConverter.convertToListDTO(recipe.getIngredients()))
                .cookingTime(recipe.getCookingTime())
                .difficulty(recipe.getDifficulty())
                .createdAt(recipe.getCreatedAt())
                .image(recipe.getImage())
                .build();
    }

    public static List<RecipeGetDTO> convertToListDTO(List<Recipe> recipeList){
        List<RecipeGetDTO> recipeGetDTOList = new ArrayList<>();
        for (Recipe recipe: recipeList){
            recipeGetDTOList.add(convertToDTO(recipe));
        }
        return recipeGetDTOList;
    }
    public static Recipe convertToEntity(RecipePostDTO recipePostDTO){
        return Recipe.builder()
                .id(recipePostDTO.getId())
                .title(recipePostDTO.getTitle())
                .instructions(recipePostDTO.getInstructions())
                .cookingTime(recipePostDTO.getCookingTime())
                .createdAt(LocalDateTime.now())
                .difficulty(recipePostDTO.getDifficulty())
                .image(recipePostDTO.getImage())
                .build();
    }
}
