package com.wte.wteapi.repository;

import com.wte.wteapi.entity.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientsRepository extends JpaRepository<Ingredients, Integer> {
}
