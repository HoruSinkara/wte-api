package com.wte.wteapi.repository;

import com.wte.wteapi.entity.RecipesIngredients;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipesIngredientsRepository extends JpaRepository<RecipesIngredients, Long> {
    List<RecipesIngredients> findAllByIngredientId(Integer ingredientId);
}
