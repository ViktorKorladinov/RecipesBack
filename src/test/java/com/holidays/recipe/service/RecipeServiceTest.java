package com.holidays.recipe.service;

import com.holidays.recipe.domain.Recipe;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class RecipeServiceTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private RecipeService recipeService;

    @Test
    public void createRecipe() {
        Recipe rep = new Recipe();
        rep.setName("Test");
        rep.setCountry("testCountry");
        rep.setDescription("testDesc");
        List<String> l = new ArrayList<>();
        l.add("testIng");
        l.add("testIng2");
        rep.setIngredients(l);
        Recipe result = recipeService.createRecipe(rep);
    }

    @Test
    public void getRecipesByCountry() {
    }
}