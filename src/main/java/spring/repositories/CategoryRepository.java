package spring.repositories;

import org.springframework.data.repository.CrudRepository;
import spring.domain.Category;

import java.util.Optional;

/**
 * Created by Piotr on 2020-06-25
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {
    Optional<Category> findByDescription (String description);
}
