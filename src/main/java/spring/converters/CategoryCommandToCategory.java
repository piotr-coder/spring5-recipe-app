package spring.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import spring.commands.CategoryCommand;
import spring.domain.Category;

/**
 * Created by Piotr on 2020-08-18
 */
@Component
public class CategoryCommandToCategory implements Converter <CategoryCommand, Category> {
    @Synchronized
    @Nullable
    @Override
    public Category convert(CategoryCommand source) {
        if(source == null){
            return null;
        }

        final Category category = new Category();
        category.setId(source.getId());
        category.setDescription(source.getDescription());
        return category;
    }
}
