package com.wte.wteapi.service;

import com.wte.wteapi.entity.RecipesIngredients;
import com.wte.wteapi.repository.RecipesIngredientsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipesIngredientsService {
    private final RecipesIngredientsRepository recipesIngredientsRepository;

    public List<RecipesIngredients> addAll(List<RecipesIngredients> recipesIngredientsList){
        return recipesIngredientsRepository.saveAll(recipesIngredientsList);
    }
}
