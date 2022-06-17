package ru.example.recipeBook.service;

import org.springframework.stereotype.Service;
import ru.example.recipeBook.dao.RecipeDAO;
import ru.example.recipeBook.entity.Recipe;

@Service
public class RecipeService {
    private final RecipeDAO recipeDAO;

    public RecipeService(RecipeDAO recipeDAO) {
        this.recipeDAO = recipeDAO;
    }

    public void insertRecipe(Recipe recipe) {
        recipeDAO.insertRecipe(recipe);
        System.out.println("Inserted: " + recipe.getTitle());
    }
}
