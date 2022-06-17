package ru.example.recipeBook.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.example.recipeBook.entity.Recipe;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RecipeMapper implements RowMapper<Recipe> {

    @Override
    public Recipe mapRow(ResultSet rs, int rowNum) throws SQLException {
        Recipe recipe = new Recipe();
        recipe.setTitle(rs.getString("title"));

        return null;
    }
}
