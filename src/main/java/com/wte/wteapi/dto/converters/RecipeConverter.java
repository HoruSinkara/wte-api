package com.wte.wteapi.dto.converters;

import com.wte.wteapi.dto.RecipeGetDTO;
import com.wte.wteapi.entity.Recipe;

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
                .build();
    }

    public static List<RecipeGetDTO> convertToListDTO(List<Recipe> recipeList){
        List<RecipeGetDTO> recipeGetDTOList = new ArrayList<>();
        for (Recipe recipe: recipeList){
            recipeGetDTOList.add(convertToDTO(recipe));
        }
        return recipeGetDTOList;
    }
}
