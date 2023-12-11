package com.wte.wteapi.controller;

import com.wte.wteapi.dto.RecipeGetDTO;
import com.wte.wteapi.dto.converters.RecipeConverter;
import com.wte.wteapi.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService recipeService;
    @GetMapping
    public ResponseEntity<List<RecipeGetDTO>> getRecipes(){
        return new ResponseEntity<>(RecipeConverter.convertToListDTO(recipeService.getRecipes()), HttpStatus.OK);
    }
}
