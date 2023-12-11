package com.wte.wteapi.repository;

import com.wte.wteapi.entity.RecipesIngredients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipesIngredientsRepository extends JpaRepository<RecipesIngredients, Long> {
}
