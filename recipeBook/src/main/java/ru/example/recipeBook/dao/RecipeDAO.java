package ru.example.recipeBook.dao;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import ru.example.recipeBook.entity.Ingredients;
import ru.example.recipeBook.entity.Recipe;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Repository
public class RecipeDAO {
    private final JdbcTemplate recipeJdbcTemplate;
    private final NamedParameterJdbcTemplate recipeNamedJdbcTemplate;

    public RecipeDAO(JdbcTemplate recipeJdbcTemplate, NamedParameterJdbcTemplate recipeNamedJdbcTemplate) {
        this.recipeJdbcTemplate = recipeJdbcTemplate;
        this.recipeNamedJdbcTemplate = recipeNamedJdbcTemplate;
    }

    public void insertRecipe(final Recipe recipe) {
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(recipe);
        int result = recipeNamedJdbcTemplate.update("INSERT INTO recipes (title) " +
                " VALUES (:title)", sqlParameterSource);
        System.out.println(result == 1 ? "ok" : "fail");

        final List<Ingredients> ingredients = recipe.getIngredients();
        int[] changedRows =recipeJdbcTemplate.batchUpdate(
                "INSERT INTO ingredients (recipe_title, ingredient, count, measurement) " +
                "VALUES (?, ?, ?, ?)", new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, recipe.getTitle());
                ps.setString(2, ingredients.get(i).getIngredient());
                ps.setInt(3, ingredients.get(i).getCount());
                ps.setString(4, ingredients.get(i).getMeasurement().toString());
            }

            public int getBatchSize() {
                return ingredients.size();
            }
        });

        int totalUpdates = Arrays.stream(changedRows).sum();
        System.out.println("TOTAL INSERTS - " + totalUpdates);
    }

    public List<Map<String, Object>> getAllRecipes() {
        return recipeJdbcTemplate.queryForList("select * from ingredients");
    }
}
