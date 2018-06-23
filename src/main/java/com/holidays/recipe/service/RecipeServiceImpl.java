package com.holidays.recipe.service;

import com.holidays.recipe.domain.Recipe;
import com.holidays.recipe.repository.RecipeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("recipeService")
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository repository;

    public RecipeServiceImpl(RecipeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Recipe createRecipe(Recipe recipe) {
        return repository.save(recipe);
    }

    @Override
    public List<Recipe> getRecipesByCountry(String country) {
        return repository.findAllByCountry(country);
    }
}
