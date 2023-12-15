package com.wte.wteapi.service;

import com.wte.wteapi.entity.Ingredient;
import com.wte.wteapi.entity.Recipe;
import com.wte.wteapi.entity.RecipesIngredients;
import com.wte.wteapi.repository.RecipeRepository;
import com.wte.wteapi.repository.RecipesIngredientsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeRepository recipeRepository;

    public List<Recipe> getRecipes(){
        return recipeRepository.findAll();
    }

    public Recipe addRecipe(Recipe recipe){
        return recipeRepository.save(recipe);
    }

    public Optional<Recipe> findByIdRecipe(Long id){
        return recipeRepository.findById(id);
    }
}
