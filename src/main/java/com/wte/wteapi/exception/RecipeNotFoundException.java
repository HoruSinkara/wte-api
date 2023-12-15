package com.wte.wteapi.exception;


public class RecipeNotFoundException extends RuntimeException{
    public RecipeNotFoundException(Long id){super(String.format("Рецепт с id: {%s} не найден", id));}
}
