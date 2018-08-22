package com.holidays.recipe.rest;

import com.holidays.recipe.domain.Recipe;
import com.holidays.recipe.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
    @GetMapping(path ="/{country}")
    public ResponseEntity<List<Recipe>>getRecipeByCountry(@PathVariable("country") String country){
        return ResponseEntity.ok(recipeService.getRecipesByCountry(country));
    }
    @GetMapping(path ="")
    public ResponseEntity<List<Recipe>>getAllRecipes(){
        return ResponseEntity.ok(recipeService.findAll());
    }
    @GetMapping(path ="/id/{id}")
    public ResponseEntity<Recipe>getRecipeById(@PathVariable("id") Long id){
        return ResponseEntity.ok(recipeService.getRecipeById(id));
    }
    @PostMapping
    public ResponseEntity createRecipe(@RequestBody Recipe recipe){
        Recipe result = recipeService.createRecipe(recipe);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
                "/{id}").buildAndExpand(result.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
