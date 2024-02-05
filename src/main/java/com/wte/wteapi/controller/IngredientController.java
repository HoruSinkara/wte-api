package com.wte.wteapi.controller;

import com.wte.wteapi.dto.IngredientDTO;
import com.wte.wteapi.dto.converters.IngredientConverter;
import com.wte.wteapi.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ingredient")
public class IngredientController {
    private final IngredientService ingredientService;
    @GetMapping
    public ResponseEntity<List<IngredientDTO>> getIngredients(){
        return new ResponseEntity<>(IngredientConverter.convertToListDTO(ingredientService.getIngredients()), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<IngredientDTO> addIngredient(@RequestBody IngredientDTO ingredientDTO){
        return new ResponseEntity<>(IngredientConverter.convertToDTO(ingredientService.addIngredient(IngredientConverter.convertToEntity(ingredientDTO))), HttpStatus.CREATED);
    }
}
