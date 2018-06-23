package com.holidays.recipe.repository;
import com.holidays.recipe.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe,Long> {
    List<Recipe>findAllByCountry(String country);
}
