package spring.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import spring.commands.IngredientCommand;
import spring.domain.Ingredient;

/**
 * Created by Piotr on 2020-08-18
 */
@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {
    private final spring.converters.UnitOfMeasureCommandToUnitOfMeasure uomConverter;

    public IngredientCommandToIngredient(spring.converters.UnitOfMeasureCommandToUnitOfMeasure uomConverter) {
        this.uomConverter = uomConverter;
    }

    @Nullable
    @Override
    public Ingredient convert(IngredientCommand source) {
        if(source == null){
            return null;
        }
        final Ingredient ingredient = new Ingredient();
        ingredient.setId(source.getId());
        ingredient.setAmount(source.getAmount());
        ingredient.setDescription(source.getDescription());
        ingredient.setUom(uomConverter.convert(source.getUom()));
        return ingredient;
    }
}
