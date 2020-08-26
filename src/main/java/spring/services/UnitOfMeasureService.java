package spring.services;

import spring.commands.UnitOfMeasureCommand;

import java.util.Set;

/**
 * Created by Piotr on 2020-08-25
 */
public interface UnitOfMeasureService {
    Set<UnitOfMeasureCommand> listAllUoms();
}
