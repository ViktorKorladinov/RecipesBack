package com.holidays.recipe.service;

import com.holidays.recipe.domain.Recipe;
import java.util.List;

public interface RecipeService {
    Recipe createRecipe(Recipe recipe);
    List<Recipe> getRecipesByCountry(String country);
    List<Recipe> findAll();
    Recipe getRecipeById(Long id);
}
