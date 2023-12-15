package com.wte.wteapi.controller;

import com.wte.wteapi.dto.ErrorResponseDTO;
import com.wte.wteapi.dto.IngredientDTO;
import com.wte.wteapi.dto.converters.IngredientConverter;
import com.wte.wteapi.exception.IngredientThereLinkException;
import com.wte.wteapi.service.IngredientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ingredient")
@Slf4j
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
    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteIngredientById(@RequestParam Integer ingredientId){
            ingredientService.deleteIngredientById(ingredientId);
            log.info("Удаление объекта{}", String.format("Удаление ингредиента с id: %s", ingredientId));
            return new ResponseEntity<>(HttpStatus.OK);
    }
    @ExceptionHandler(IngredientThereLinkException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ErrorResponseDTO handleException(IngredientThereLinkException ex) {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
        errorResponseDTO.setMessage(ex.getMessage());
        log.info("Ошибка: {}", errorResponseDTO.getMessage());
        return errorResponseDTO;
    }
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponseDTO handleException(Exception ex) {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
        errorResponseDTO.setMessage(ex.getMessage());
        log.info("Ошибка общего формата:{}", errorResponseDTO.getMessage());
        return errorResponseDTO;
    }
}
