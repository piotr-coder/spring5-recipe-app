package spring.repositories;

import org.springframework.data.repository.CrudRepository;
import spring.domain.UnitOfMeasure;

import java.util.Optional;

/**
 * Created by Piotr on 2020-06-25
 */
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
    Optional<UnitOfMeasure> findByDescription (String description);
}
