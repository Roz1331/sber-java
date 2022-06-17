package ru.example.recipeBook.entity;


public class Ingredients {

    private int id;
//    private String recipeTitle;
    private String ingredient;
    private int count;
    private Measurement measurement;

    public Ingredients(String ingredient, int count, Measurement measurement) {
//        this.recipeTitle = recipeTitle;
        this.ingredient = ingredient;
        this.count = count;
        this.measurement = measurement;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
//
//    public String getRecipeTitle() {
//        return recipeTitle;
//    }
//
//    public void setRecipeTitle(String recipeTitle) {
//        this.recipeTitle = recipeTitle;
//    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    @Override
    public String toString() {
        return "Ingredients{" +
                "id=" + id +
                ", ingredient='" + ingredient + '\'' +
                ", count=" + count +
                ", measurement=" + measurement +
                '}';
    }
}
