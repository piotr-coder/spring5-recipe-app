package spring.repositories;

import org.springframework.data.repository.CrudRepository;
import spring.domain.Recipe;

/**
 * Created by Piotr on 2020-06-25
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
