package spring.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import spring.commands.IngredientCommand;
import spring.domain.Ingredient;

/**
 * Created by Piotr on 2020-08-18
 */
@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {
    private final spring.converters.UnitOfMeasureToUnitOfMeasureCommand uomConverter;

    public IngredientToIngredientCommand(spring.converters.UnitOfMeasureToUnitOfMeasureCommand uomConverter) {
        this.uomConverter = uomConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public IngredientCommand convert(Ingredient ingredient) {
        if(ingredient == null){
            return null;
        }
        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(ingredient.getId());
        ingredientCommand.setAmount(ingredient.getAmount());
        ingredientCommand.setDescription(ingredient.getDescription());
        ingredientCommand.setUnitOfMeasure(uomConverter.convert(ingredient.getUom()));
        return ingredientCommand;
    }
}
