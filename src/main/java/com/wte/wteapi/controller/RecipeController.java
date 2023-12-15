package com.wte.wteapi.controller;

import com.wte.wteapi.dto.*;
import com.wte.wteapi.dto.converters.RecipeConverter;
import com.wte.wteapi.entity.Ingredient;
import com.wte.wteapi.entity.Recipe;
import com.wte.wteapi.entity.RecipesIngredients;
import com.wte.wteapi.service.RecipeService;
import com.wte.wteapi.service.RecipesIngredientsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService recipeService;
    private final RecipesIngredientsService recipesIngredientsService;
    @GetMapping
    public ResponseEntity<List<RecipeGetDTO>> getRecipes(){
        log.info("Отправлен список рецептов");
        return new ResponseEntity<>(RecipeConverter.convertToListDTO(recipeService.getRecipes()), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<RecipeGetDTO> addRecipe(@RequestBody RecipePostDTO recipePostDTO){
        Recipe recipe = recipeService.addRecipe(RecipeConverter.convertToEntity(recipePostDTO));
        List<RecipesIngredients> recipesIngredientsList = new ArrayList<>();
        for (RecipesIngredientsDTO ingredientDTO:recipePostDTO.getIngredients()){
            recipesIngredientsList.add(
                    RecipesIngredients.builder()
                            .recipeId(recipe.getId())
                            .recipe(recipe)
                            .ingredientId(ingredientDTO.getId())
                            .ingredient(Ingredient.builder()
                                    .id(ingredientDTO.getId())
                                    .name(ingredientDTO.getName())
                                    .build())
                            .quantity(ingredientDTO.getQuantity())
                            .build()
            );
        }

        recipesIngredientsList = recipesIngredientsService.addAll(recipesIngredientsList);
        recipe.setIngredients(recipesIngredientsList);
        recipe = recipeService.addRecipe(recipe);
        return new ResponseEntity<>(RecipeConverter.convertToDTO(recipe), HttpStatus.CREATED);
    }
    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteRecipe(@RequestParam Long recipeId){
        recipeService.deleteRecipe(recipeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    public ResponseEntity<RecipeGetDTO> updateRecipe(@RequestBody RecipePostDTO recipePostDTO){
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponseDTO handleException(Exception ex) {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
        errorResponseDTO.setMessage(ex.getMessage());
        log.info("Error: {}", errorResponseDTO.getMessage());
        return errorResponseDTO;
    }
}
