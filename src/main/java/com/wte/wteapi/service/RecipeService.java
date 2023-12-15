package com.wte.wteapi.service;


import com.wte.wteapi.entity.Recipe;

import com.wte.wteapi.exception.RecipeNotFoundException;
import com.wte.wteapi.repository.RecipeRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


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

    public void deleteRecipe(Long id){
        findByIdRecipe(id).orElseThrow(()->new RecipeNotFoundException(id)) ;
        recipeRepository.deleteById(id);
    }
}
