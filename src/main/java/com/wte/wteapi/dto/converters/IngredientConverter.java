package com.wte.wteapi.dto.converters;

import com.wte.wteapi.dto.IngredientDTO;
import com.wte.wteapi.entity.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class IngredientConverter {
    public static IngredientDTO convertToDTO(Ingredient ingredient) {
        return IngredientDTO.builder()
                .id(ingredient.getId())
                .name(ingredient.getName())
                .build();
    }
    public static  List<IngredientDTO> convertToListDTO(List<Ingredient> ingredientList){
        List<IngredientDTO> ingredientDTOList = new ArrayList<>();
        for (Ingredient ingredient: ingredientList){
            ingredientDTOList.add(convertToDTO(ingredient));
        }
        return ingredientDTOList;
    }
}
