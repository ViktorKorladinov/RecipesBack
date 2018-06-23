package com.holidays.recipe.rest;

import com.holidays.recipe.domain.Recipe;
import com.holidays.recipe.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
    @GetMapping(path ="/{country}")
    public ResponseEntity<List<Recipe>>getRecipe(@PathVariable("country") String country){
        return ResponseEntity.ok(recipeService.getRecipesByCountry(country));
    }
    @PostMapping
    public ResponseEntity createRecipe(@RequestBody Recipe recipe){
        Recipe result = recipeService.createRecipe(recipe);
        URI uri = MvcUriComponentsBuilder.fromMethodName(RecipeController.class, "getRecipe", result.getId()).build(result.getId());
        return ResponseEntity.created(uri).build();
    }
}
