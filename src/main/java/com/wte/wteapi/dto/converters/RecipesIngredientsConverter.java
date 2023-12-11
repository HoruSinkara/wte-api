package com.wte.wteapi.dto.converters;

import com.wte.wteapi.dto.IngredientDTO;
import com.wte.wteapi.dto.RecipesIngredientsDTO;
import com.wte.wteapi.entity.RecipesIngredients;

import java.util.ArrayList;
import java.util.List;

public class RecipesIngredientsConverter {
    public static RecipesIngredientsDTO convertToDTO(RecipesIngredients recipesIngredients){
        IngredientDTO ingredientDTO = IngredientConverter.convertToDTO(recipesIngredients.getIngredient());
        return RecipesIngredientsDTO.builder()
                .id(ingredientDTO.getId())
                .name(ingredientDTO.getName())
                .quantity(recipesIngredients.getQuantity())
                .build();
    }

    public static List<RecipesIngredientsDTO> convertToListDTO(List<RecipesIngredients> recipesIngredientsList){
        List<RecipesIngredientsDTO> recipesIngredientsDTOList = new ArrayList<>();
        for(RecipesIngredients recipesIngredients: recipesIngredientsList){
            recipesIngredientsDTOList.add(convertToDTO(recipesIngredients));
        }
        return  recipesIngredientsDTOList;
    }
}
