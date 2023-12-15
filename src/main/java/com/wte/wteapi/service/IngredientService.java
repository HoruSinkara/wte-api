package com.wte.wteapi.service;

import com.wte.wteapi.entity.Ingredient;
import com.wte.wteapi.exception.IngredientThereLinkException;
import com.wte.wteapi.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientService {
    private final IngredientRepository ingredientRepository;
    private final RecipesIngredientsService recipesIngredientsService;

    public List<Ingredient> getIngredients(){
        return ingredientRepository.findAll();
    }

    public Ingredient addIngredient(Ingredient ingredient){
        return ingredientRepository.save(ingredient);
    }

    public void deleteIngredientById(Integer id){
        if (!recipesIngredientsService.getListByIngredientId(id).isEmpty()){
            throw new IngredientThereLinkException("Ингредиент используется в рецептах блюд");
        }
        ingredientRepository.deleteById(id);
    }
}
