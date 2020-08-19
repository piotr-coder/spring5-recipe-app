package spring.services;

import spring.commands.RecipeCommand;
import spring.domain.Recipe;

import java.util.Set;

/**
 * Created by Piotr on 2020-07-10
 */
public interface RecipeService {
    Set<Recipe> getRecipes();
    Recipe findById(Long l);
    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
