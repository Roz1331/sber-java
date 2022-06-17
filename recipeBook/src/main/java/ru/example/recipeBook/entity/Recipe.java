package ru.example.recipeBook.entity;

import java.util.List;
import java.util.Map;

public class Recipe {

    private int id;
    private String title;
    private List<Ingredients> ingredients;

    public Recipe() {}

    public Recipe(String title, List<Ingredients> ingredients) {
        this.title = title;
        this.ingredients = ingredients;
    }

    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
