package spring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import spring.commands.IngredientCommand;
import spring.converters.IngredientToIngredientCommand;
import spring.domain.Recipe;
import spring.repositories.RecipeRepository;

import java.util.Optional;

/**
 * Created by Piotr on 2020-08-25
 */
@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final RecipeRepository recipeRepository;

    public IngredientServiceImpl(IngredientToIngredientCommand ingredientToIngredientCommand, RecipeRepository recipeRepository) {
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);
        if(!recipeOptional.isPresent()){
            // todo impl error hendling
            log.error("Recipe id not found. Id: " + recipeId);
        }
        Recipe recipe = recipeOptional.get();

        Optional<IngredientCommand> ingredientCommandOptional = recipe.getIngredients().stream()
                .filter(ingredient -> ingredient.getId().equals(ingredientId))
                .map(ingredient -> ingredientToIngredientCommand.convert(ingredient)).findFirst();
        if(!ingredientCommandOptional.isPresent()){
            // todo impl error hendling
            log.error("Ingredient id not found. Id: " + ingredientId);
        }
        return ingredientCommandOptional.get();
    }
}
