package com.wte.wteapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name = "recipes_ingredients")
@AllArgsConstructor
@NoArgsConstructor
public class RecipesIngredients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "recipe_id",insertable=false, updatable=false)
    private Long recipeId;
    @Column(name = "ingredient_id", insertable=false, updatable=false)
    private Integer ingredientId;

    private String quantity;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "ingredient_id"), name = "ingredient_id")
    private Ingredient ingredient;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "recipe_id"), name = "recipe_id")
    @JsonIgnore
    private Recipe recipe;
}
