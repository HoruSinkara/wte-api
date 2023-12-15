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
    public static Ingredient convertToEntity(IngredientDTO ingredientDTO){
        return Ingredient.builder()
                .id(ingredientDTO.getId())
                .name(ingredientDTO.getName())
                .build();
    }
    public static List<Ingredient> convertToListEntity(List<IngredientDTO> ingredientDTOList){
        List<Ingredient> ingredientList = new ArrayList<>();
        for (IngredientDTO ingredientDTO: ingredientDTOList){
            ingredientList.add(convertToEntity(ingredientDTO));
        }
        return ingredientList;
    }
}
