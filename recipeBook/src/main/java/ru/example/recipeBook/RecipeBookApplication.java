package ru.example.recipeBook;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.example.recipeBook.entity.Ingredients;
import ru.example.recipeBook.entity.Measurement;
import ru.example.recipeBook.entity.Recipe;
import ru.example.recipeBook.service.RecipeService;
import java.util.Arrays;

@ComponentScan
public class RecipeBookApplication {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RecipeBookApplication.class);

		RecipeService service = context.getBean(RecipeService.class);

		Ingredients[] ingredients = new Ingredients[] {
				new Ingredients("ing1", 1, Measurement.cup),
				new Ingredients( "ing2", 200, Measurement.grams),
				new Ingredients("ing3", 3, Measurement.teaspoon),
				new Ingredients("ing4", 500, Measurement.milliliter)
		};
		Recipe recipe = new Recipe("recipe1", Arrays.asList(ingredients));

		service.insertRecipe(recipe);



	}

}
