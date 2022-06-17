package ru.example.recipeBook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DbConfig {
//    @Bean
//    public DriverManagerDataSource recipesDataSource() {
//        return new DriverManagerDataSource("jdbc:postgresql://localhost:5432/recipes?currentSchema=public",
//                "postgres", "postgres");
//    }

    @Bean
    public JdbcTemplate recipeJdbcTemplate () {
        return new JdbcTemplate(ingredientsDataSource());
    }

    @Bean
    public NamedParameterJdbcTemplate recipeNamedParameterJdbcTemplate() {
        return new NamedParameterJdbcTemplate(ingredientsDataSource());
    }

    @Bean
    public DriverManagerDataSource ingredientsDataSource() {
        return new DriverManagerDataSource("jdbc:postgresql://localhost:5432/postgres?currentSchema=public",
                "postgres", "postgres");
    }
//
//    @Bean
//    public JdbcTemplate ingredientsJdbcTemplate () {
//        return new JdbcTemplate(ingredientsDataSource());
//    }
//
//    @Bean
//    public NamedParameterJdbcTemplate ingredientsNamedParameterJdbcTemplate() {
//        return new NamedParameterJdbcTemplate(ingredientsDataSource());
//    }

}
